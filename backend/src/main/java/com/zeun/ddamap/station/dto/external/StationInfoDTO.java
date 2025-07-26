package com.zeun.ddamap.station.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record StationInfoDTO (
        @JsonProperty("list_total_count") int totalCount,
        @JsonProperty("row") List<StationRowDTO> stationList
) {}
