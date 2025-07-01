package com.zeun.ddamap.station.controller;

import com.zeun.ddamap.station.dto.StationResponseDTO;
import com.zeun.ddamap.station.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
