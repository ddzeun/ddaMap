package com.zeun.ddamap.route.dto;

public record RouteRequestDTO(

        WaypointDTO origin,
        WaypointDTO destination,
        RouteTravelMode travelMode
) {}
