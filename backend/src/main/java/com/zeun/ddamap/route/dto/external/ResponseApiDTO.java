package com.zeun.ddamap.route.dto.external;

public record ResponseApiDTO(

        Integer code,
        String message,
        String currentDateTime,
        Route route
) {}
