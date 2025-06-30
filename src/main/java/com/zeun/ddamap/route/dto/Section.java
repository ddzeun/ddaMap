package com.zeun.ddamap.route.dto;

public record Section(

        Integer pointIndex,
        Integer pointCount,
        Integer distance,
        String name,
        Congestion congestion,
        Integer speed
) {}
