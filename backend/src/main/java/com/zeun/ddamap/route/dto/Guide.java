package com.zeun.ddamap.route.dto;

public record Guide(

        Integer pointIndex,
        Integer type,
        String instructions,
        Integer distance,
        Integer duration
) {}
