package com.zeun.ddamap.route.service;

import com.zeun.ddamap.route.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GoogleApiService {

    private final String apiKey;
    private final WebClient webClient;

    public GoogleApiService(@Value("${api.google.key}") String apiKey) {

        this.apiKey = apiKey;
        this.webClient = WebClient.builder()
                .baseUrl("https://routes.googleapis.com")
                .build();
    }

    public RouteApiResponseDTO getRoutes(LatLngDTO originLatLng, LatLngDTO destinationLatLng, RouteTravelMode travelMode) {
        RouteRequestDTO requestBody = new RouteRequestDTO(
                new WaypointDTO(new LocationDTO(originLatLng)),
                new WaypointDTO(new LocationDTO(destinationLatLng)),
                travelMode
        );

        return webClient.post()
                .uri("/directions/v2:computeRoutes")
                .header("Content-Type", "application/json")
                .header("X-Goog-Api-Key", apiKey)
                .header("X-Goog-FieldMask", "*")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(RouteApiResponseDTO.class)
                .block();
    }
}