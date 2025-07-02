package com.zeun.ddamap.route.dto;

import org.locationtech.jts.geom.Point;

public record NearbyStationDTO(

        String stnId,
        String stnName,
        String address,
        Double distance,
        Double latitude,
        Double longitude
) {}

