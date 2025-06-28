package com.zeun.ddamap.station.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StationApiResponse (

    @JsonProperty("stationInfo") StationInfoDTO stationInfoDTO
) {}
