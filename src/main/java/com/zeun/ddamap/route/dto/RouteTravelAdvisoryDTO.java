package com.zeun.ddamap.route.dto;

import java.util.List;

public record RouteTravelAdvisoryDTO(

        TollInfoDTO tollInfo,
        List<SpeedReadingIntervalDTO> speedReadingInterval,
        String fuelConsumptionMicroliters,
        Boolean routeRestrictionsPartiallyIgnored,
        MoneyDTO transitFare
) {}
