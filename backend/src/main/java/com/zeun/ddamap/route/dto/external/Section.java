package com.zeun.ddamap.route.dto.external;

public record Section(

        Integer pointIndex,
        Integer pointCount,
        Integer distance,
        String name,
        Congestion congestion,
        Integer speed
) {}
