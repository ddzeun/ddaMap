package com.zeun.ddamap.controller;

import com.zeun.ddamap.dto.StationResponseDTO;
import com.zeun.ddamap.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stations")
public class StationController {

    private final StationService stationService;

    @GetMapping
    public List<StationResponseDTO> getAllStations() {

        return stationService.getAllStations();
    }
}
