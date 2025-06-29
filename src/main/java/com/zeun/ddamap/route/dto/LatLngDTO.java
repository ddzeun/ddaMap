package com.zeun.ddamap.route.dto;

import java.math.BigDecimal;

public record LatLngDTO(

        BigDecimal latitude,
        BigDecimal longitude
) {}
