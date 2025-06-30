package com.zeun.ddamap.route.dto;

import java.math.BigDecimal;
import java.util.List;

public record RouteDTO(

        Summary summary,
        List<List<BigDecimal>> path,
        List<Section> section,
        List<Guide> guide
) {}
