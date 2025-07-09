package com.zeun.ddamap.station.service;

import com.zeun.ddamap.station.repository.LocationGroupRepository;
import com.zeun.ddamap.station.repository.StationRepository;
import com.zeun.ddamap.station.service.StationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("local")
public class StationServiceTest {

    @Autowired
    private StationService stationService;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private LocationGroupRepository locationGroupRepository;

    @Test
    @DisplayName("Station list save and LocationGroup find or create test")
    public void testUpdateStationData() {

        // given
        stationRepository.deleteAll();
        locationGroupRepository.deleteAll();

        // when
        stationService.updateStationData();

        // then
        long stationCount = stationRepository.count();
        long groupCount = locationGroupRepository.count();

        System.out.println("저장된 그룹 수 = " + groupCount);
        System.out.println("저장된 대여소 수 = " + stationCount);
    }
}
