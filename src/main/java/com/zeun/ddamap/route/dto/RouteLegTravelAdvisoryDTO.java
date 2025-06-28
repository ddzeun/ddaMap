package com.zeun.ddamap.route.dto;

import java.util.List;

public record RouteLegTravelAdvisoryDTO(

        TollInfoDTO tollInfo,
        List<SpeedReadingIntervalDTO> speedReadingIntervals
) {}
