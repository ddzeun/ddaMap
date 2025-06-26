package com.zeun.ddamap.dto;

import java.math.BigDecimal;

public record StationResponseDTO(

        String stationId,
        String stationName,
        String address,
        BigDecimal latitude,
        BigDecimal longitude
) {}
