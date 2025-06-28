package com.zeun.ddamap.route.dto;

public record FlyoverInfoDTO(

        RoadFeatureState flyoverPresence,
        PolylinePointIndexDTO polylinePointIndex
) {
}
