package com.zeun.ddamap.station.dto.externalRealtime;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BikeStatusApiResponseDTO(
        @JsonProperty("rentBikeStatus") RentBikeStatusDTO rentBikeStatus
) {}
