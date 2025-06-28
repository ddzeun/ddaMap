package com.zeun.ddamap.station.service;

import com.zeun.ddamap.station.dto.StationApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StationApiService {

    private final WebClient webClient;
    private final String apiKey;

    public StationApiService(WebClient webClient, @Value("${api.seoul.key}") String apiKey) {

        this.webClient = webClient;
        this.apiKey = apiKey;
    }

    public StationApiResponse fetchStationData() {

        String path = String.format("/%s/json/tbCycleStationInfo/1/1000/", apiKey);

        Mono<StationApiResponse> mono = webClient.get()
                .uri(path)
                .retrieve()
                .bodyToMono(StationApiResponse.class);

        return mono.block();
    }
}