package com.zeun.ddamap.route.service;

import com.zeun.ddamap.route.dto.ResponseApiDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.List;

@Service
public class NaverApiService {

    private final WebClient webClient;
    private final String clientId;
    private final String clientSecret;

    public NaverApiService(@Value("${api.naver.client-id}") String clientId,
                           @Value("${api.naver.client-secret}") String clientSecret) {

        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.webClient = WebClient.builder()
                .baseUrl("https://maps.apigw.ntruss.com")
                .build();
    }

    public ResponseApiDTO getDirections(List<BigDecimal> start, List<BigDecimal> goal) {

        // 경도 + 위도
        String startCoord = start.get(0) + "," + start.get(1);
        String goalCoord = goal.get(0) + "," + goal.get(1);

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/map-direction/v1/driving")
                        .queryParam("start", startCoord)
                        .queryParam("goal", goalCoord)
//                        .queryParam("waypoints", waypoint)    최대 5개의 경유지 입력 가능, |로 구분
                        .queryParam("option", "traavoidcaronly")    // 자동차 전용 도로 회피 우선
                        .build())
                .header("x-ncp-apigw-api-key-id", clientId)
                .header("x-ncp-apigw-api-key", clientSecret)
                .retrieve()
                .bodyToMono(ResponseApiDTO.class)
                .block();
    }
}