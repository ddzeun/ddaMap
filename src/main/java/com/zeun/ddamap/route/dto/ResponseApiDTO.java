package com.zeun.ddamap.route.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ResponseApiDTO(

        Integer code,
        String message,
        String currentDateTime,
        Route route
) {}
