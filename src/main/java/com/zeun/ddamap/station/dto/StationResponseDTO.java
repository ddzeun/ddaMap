package com.zeun.ddamap.station.dto;

import java.math.BigDecimal;

public record StationResponseDTO(

        String stationId,
        String stationName,
        String address,
        BigDecimal latitude,
        BigDecimal longitude
) {}
