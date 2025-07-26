package com.zeun.ddamap.station.service;

import com.zeun.ddamap.station.dto.external.StationApiResponse;
import com.zeun.ddamap.station.dto.external.StationRowDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class StationApiService {

    private final WebClient webClient;
    private final String apiKey;

    public StationApiService(WebClient webClient, @Value("${api.seoul.key}") String apiKey) {

        this.webClient = webClient;
        this.apiKey = apiKey;
    }

    public List<StationRowDTO> fetchAllStationData() {
        StationApiResponse initialResponse = callBikeApi(1, 1);
        int totalCount = initialResponse.stationInfoDTO().totalCount();
        List<StationRowDTO> allStations = new ArrayList<>();

        for (int start = 1; start <= totalCount; start += 1000) {
            int end = start + 999;
            if (end > totalCount) {
                end = totalCount;
            }

            System.out.println("Fetching stations from " + start + " to " + end);

            StationApiResponse response = callBikeApi(start, end);

            if (response != null && response.stationInfoDTO() != null && response.stationInfoDTO().stationList() != null) {
                allStations.addAll(response.stationInfoDTO().stationList());
            }
        }
        return allStations;
    }

    private StationApiResponse callBikeApi(int startIndex, int endIndex) {
        String serviceName = "tbCycleStationInfo";
        String path = String.format("/%s/json/%s/%d/%d/", apiKey, serviceName, startIndex, endIndex);

        Mono<StationApiResponse> mono = webClient.get()
                .uri(path)
                .retrieve()
                .bodyToMono(StationApiResponse.class);

        return mono.block();
    }
}