package com.zeun.ddamap.route.dto;

import java.util.List;

public record RouteDTO(

        List<RouteLabel> routeLabels,
        List<RouteLegDTO> legs,
        Integer distanceMeters,
        String duration,
        String staticDuration,
        PolylineDTO polyline,
        String description,
        List<String> warnings,
        ViewportDTO viewport,
        RouteTravelAdvisoryDTO travelAdvisory,
        List<Integer> optimizedIntermediateWaypointIndex,
        RouteLocalizedValuesDTO localizedValues,
        String routeToken,
        PolylineDetailsDTO polylineDetails
) {}
