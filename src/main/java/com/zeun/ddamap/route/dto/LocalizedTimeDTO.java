package com.zeun.ddamap.route.dto;

public record LocalizedTimeDTO(

        LocalizedTextDTO time,
        String timeZone
) {}
