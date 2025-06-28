package com.zeun.ddamap.route.dto;

public record RouteLegStepTransitDetailsDTO(

        TransitStopDetailsDTO stopDetails,
        TransitDetailsLocalizedValuesDTO localizedValues,
        String headsign,
        String headway,
        TransitLineDTO transitLine,
        Integer stopCount,
        String tripShortText
) {}
