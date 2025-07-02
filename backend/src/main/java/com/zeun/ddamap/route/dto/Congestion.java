package com.zeun.ddamap.route.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum Congestion {

    NONE(0),
    SMOOTH(1),
    SLOW(2),
    CONGESTED(3);

    private final int value;

    Congestion(int value) {

        this.value = value;
    }

    @JsonCreator
    public static Congestion fromValue(int value) {

        return Stream.of(Congestion.values())
                .filter(c -> c.value == value)
                .findFirst()
                .orElse(null);
    }
}
