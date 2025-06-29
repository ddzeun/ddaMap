package com.zeun.ddamap.route.dto;

import java.util.List;

public record GeocodingResultsDTO(

        GeocodedWaypointDTO geocodedWaypoint,
        GeocodedWaypointDTO destination,
        List<GeocodedWaypointDTO> intermediates
) {}

