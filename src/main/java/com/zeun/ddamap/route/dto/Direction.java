package com.zeun.ddamap.route.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum Direction {

    FORWARD(0),
    LEFT(1),
    RIGHT(2);

    private final int value;

    Direction(int value) {

        this.value = value;
    }

    @JsonCreator
    public static Direction fromValue(int value) {

        return Stream.of(Direction.values())
                .filter(c -> c.value == value)
                .findFirst()
                .orElse(null);
    }
}
