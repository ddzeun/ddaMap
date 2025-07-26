package com.zeun.ddamap.route.dto.response;

public record NearbyStationDTO(

        String stnId,
        String stnName,
        String address,
        Double distance,
        Double latitude,
        Double longitude
) {}

