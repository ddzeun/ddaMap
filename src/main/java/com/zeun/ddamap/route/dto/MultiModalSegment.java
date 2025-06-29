package com.zeun.ddamap.route.dto;

public record MultiModalSegment(

        NavigationInstructionDTO navigationInstruction,
        RouteTravelMode travelMode,
        Integer stepStartIndex,
        Integer stepEndIndex
) {}
