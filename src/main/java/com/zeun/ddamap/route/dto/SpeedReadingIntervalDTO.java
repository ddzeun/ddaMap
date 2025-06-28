package com.zeun.ddamap.route.dto;

public record SpeedReadingIntervalDTO(

        Integer startPolylinePointIndex,
        Integer endPolylinePointIndex,
        Speed speed
) {}
