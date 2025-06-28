package com.zeun.ddamap.route.dto;

public record RouteLocalizedValuesDTO(

        LocalizedTextDTO distance,
        LocalizedTextDTO duration,
        LocalizedTextDTO staticDuration,
        LocalizedTextDTO transitFare
) {}
