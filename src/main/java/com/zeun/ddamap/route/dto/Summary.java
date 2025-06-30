package com.zeun.ddamap.route.dto;

import java.math.BigDecimal;
import java.util.List;

public record Summary(

        Location start,
        Location goal,
        Integer distance,
        Integer duration,
        String departureTime,
        List<List<BigDecimal>> bbox,
        Integer tollFare,
        Integer taxiFare,
        Integer fuelPrice
) {}
