package com.zeun.ddamap.station.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LocationGroupDTO(

        @JsonProperty("group_id") Long groupId,
        @JsonProperty("group_name") String groupName
) {}
