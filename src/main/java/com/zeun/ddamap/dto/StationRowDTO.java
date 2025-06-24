package com.zeun.ddamap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record StationRowDTO (

        @JsonProperty("RENT_ID") String stnId,

        @JsonProperty("RENT_NO") String stnNo,

        @JsonProperty("RENT_NM") String stnName,

        @JsonProperty("STA_LOC") String stnLoc,

        @JsonProperty("STA_ADD1") String stnAddr1,

        @JsonProperty("STA_ADD2") String stnAddr2,

        @JsonProperty("STA_LAT") BigDecimal stnLat,

        @JsonProperty("STA_LONG") BigDecimal stnLong,

        @JsonProperty("HOLD_NUM") Integer holdCount
) {}