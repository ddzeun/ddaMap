package com.zeun.ddamap.route.dto;

import java.util.List;

public record PolylineDetailsDTO(

        List<FlyoverInfoDTO> flyoverInfo,
        List<NarrowRoadInfoDTO> narrowRoadInfo
) {}
