package com.zeun.ddamap.route.dto;

public record RouteLegStepDTO(

        Integer distanceMeters,
        String staticDuration ,
        PolylineDTO polyline,
        LocationDTO startLocation,
        LocationDTO endLocation,
        NavigationInstructionDTO navigationInstruction,
        RouteLegStepTravelAdvisoryDTO travelAdvisory,
        RouteLegStepLocalizedValuesDTO localizedValues,
        RouteLegStepTransitDetailsDTO transitDetails,
        RouteTravelMode travelMode
) {}
