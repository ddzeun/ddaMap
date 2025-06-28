package com.zeun.ddamap.route.dto;

public record TransitVehicleDTO(

        LocalizedTextDTO name,
        TransitVehicleType type,
        String iconUri,
        String localIconUri
) {}
