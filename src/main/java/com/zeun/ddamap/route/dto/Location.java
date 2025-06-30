package com.zeun.ddamap.route.dto;

import java.math.BigDecimal;
import java.util.List;

public record Location(

    List<BigDecimal> location,
    Integer dir     //
) {}
