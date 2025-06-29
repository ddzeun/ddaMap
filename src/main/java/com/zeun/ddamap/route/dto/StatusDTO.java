package com.zeun.ddamap.route.dto;

import java.util.List;
import java.util.Map;

public record StatusDTO(

        Integer code,
        String message,
        List<Map<String, Object>> details
) {}
