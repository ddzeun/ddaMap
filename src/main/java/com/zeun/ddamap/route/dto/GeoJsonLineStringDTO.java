package com.zeun.ddamap.route.dto;

import java.util.List;

public record GeoJsonLineStringDTO(

        String type,
        List<List<Double>> coordinates
) {
}
