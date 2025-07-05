package com.zeun.ddamap.route.controller;

import com.zeun.ddamap.route.service.NearbyStationService;
import com.zeun.ddamap.route.dto.NearbyStationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stations")
public class NearbyStationController {

    private final NearbyStationService nearbyStationService;

    @GetMapping("/nearby")
    public List<NearbyStationDTO> findNearbyStations(@RequestParam BigDecimal lng, @RequestParam BigDecimal lat) {

        return nearbyStationService.findNearbyStationsWithDistance(lat, lng);
    }
}
