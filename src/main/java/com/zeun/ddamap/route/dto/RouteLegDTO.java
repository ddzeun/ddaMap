package com.zeun.ddamap.route.dto;

import java.util.List;

public record RouteLegDTO(

        Integer distanceMeters,
        String duration,
        String staticDuration,
        PolylineDTO polyline,
        LocationDTO startLocation,
        LocationDTO endLocation,
        List<RouteLegStepDTO> steps,
        RouteLegTravelAdvisoryDTO travelAdvisory,
        RouteLegLocalizedValuesDTO localizedValues,
        StepsOverviewDTO stepsOverviewDTO
) {}
