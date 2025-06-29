package com.zeun.ddamap.route.dto;

public record PolylineDTO(

        String encodedPolyline,
        GeoJsonLineStringDTO geoJsonLinestring
) {}
