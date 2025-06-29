package com.zeun.ddamap.route.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record RouteApiResponseDTO(

        List<RouteDTO> routes,
        FallbackInfoDTO fallbackInfo,
        GeocodingResultsDTO geocodingResults
) {}