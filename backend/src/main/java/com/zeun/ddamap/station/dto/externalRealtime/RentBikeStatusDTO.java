package com.zeun.ddamap.station.dto.externalRealtime;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record RentBikeStatusDTO(
        @JsonProperty("list_total_count") int listTotalCount,
        @JsonProperty("row") List<BikeStatusRowDTO> row
) {}
