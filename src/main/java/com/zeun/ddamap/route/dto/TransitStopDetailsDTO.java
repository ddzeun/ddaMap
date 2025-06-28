package com.zeun.ddamap.route.dto;

public record TransitStopDetailsDTO(

        TransitStopDTO arrivalStop,
        String arrivalTime,
        TransitStopDTO departureStop,
        String departureTime
) {}
