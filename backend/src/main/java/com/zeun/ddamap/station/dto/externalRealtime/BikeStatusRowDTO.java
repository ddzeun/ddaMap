package com.zeun.ddamap.station.dto.externalRealtime;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BikeStatusRowDTO(

        @JsonProperty("rackTotCnt") String rackTotalCount,
        @JsonProperty("stationName") String stationName,
        @JsonProperty("parkingBikeTotCnt") String parkingBikeTotalCount,
        @JsonProperty("shared") String shared,
        @JsonProperty("stationLatitude") String stationLatitude,
        @JsonProperty("stationLongitude") String stationLongitude,
        @JsonProperty("stationId") String stationId
) {}
