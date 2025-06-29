package com.zeun.ddamap.route.dto;

import java.util.List;

public record GeocodedWaypointDTO(

        StatusDTO geocoderStatusDTO,
        List<String> type,
        Boolean partialMatch,
        String placeId,
        Integer intermediateWaypointRequestIndex
) {}
