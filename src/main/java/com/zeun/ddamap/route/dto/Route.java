package com.zeun.ddamap.route.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Route {

    private Map<String, List<RouteDTO>> options = new ConcurrentHashMap<>();

    @JsonAnySetter
    public void addOption(String key, List<RouteDTO> routes) {

        this.options.put(key, routes);
    }

    public List<RouteDTO> getRoutes() {

        if (options.isEmpty()) {
            return List.of();
        }

        return options.values().stream().findFirst().get();
    }
}
