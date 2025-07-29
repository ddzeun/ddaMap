package com.zeun.ddamap.station.service;

import com.zeun.ddamap.station.dto.externalRealtime.BikeStatusApiResponseDTO;
import com.zeun.ddamap.station.dto.externalRealtime.BikeStatusRowDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class RealTimeStationService {

    private final WebClient webClient;
    private final String apiKey;

    public RealTimeStationService(WebClient webClient, @Value("${api.seoul.key}") String apiKey) {
        this.webClient = webClient;
        this.apiKey = apiKey;
    }

    public List<BikeStatusRowDTO> fetchAllRealtimeStations() {
        List<BikeStatusRowDTO> allStations = new ArrayList<>();
        int start = 1;
        int batchSize = 1000;

        while (true) {
            int end = start + batchSize - 1;
            System.out.println("Fetching stations from " + start + " to " + end);

            BikeStatusApiResponseDTO response = callRealtimeBikeApi(start, end);

            if (response == null || response.rentBikeStatus() == null || response.rentBikeStatus().row() == null || response.rentBikeStatus().row().isEmpty()) {
                System.out.println("No more data to fetch. Exiting loop.");
                break;
            }

            List<BikeStatusRowDTO> currentPageStations = response.rentBikeStatus().row();
            allStations.addAll(currentPageStations);
            System.out.println("Fetched " + currentPageStations.size() + " stations. Total: " + allStations.size());

            if (currentPageStations.size() < batchSize) {
                System.out.println("Last page reached. Exiting loop.");
                break;
            }

            start += batchSize;
        }

        return allStations;
    }

    private BikeStatusApiResponseDTO callRealtimeBikeApi(int startIndex, int endIndex) {
        String serviceName = "bikeList";
        String path = String.format("/%s/json/%s/%d/%d", apiKey, serviceName, startIndex, endIndex);

        Mono<BikeStatusApiResponseDTO> mono = webClient.get()
                .uri(path)
                .retrieve()
                .bodyToMono(BikeStatusApiResponseDTO.class);

        return mono.block();
    }
}