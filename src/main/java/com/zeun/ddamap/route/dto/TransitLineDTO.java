package com.zeun.ddamap.route.dto;

import java.util.List;

public record TransitLineDTO(

        List<TransitAgencyDTO> agencies,
        String name,
        String uri,
        String color,
        String iconUri,
        String nameShort,
        String textColor,
        TransitVehicleDTO vehicle
) {}
