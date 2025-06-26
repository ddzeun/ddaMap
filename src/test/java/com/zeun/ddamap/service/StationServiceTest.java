package com.zeun.ddamap.service;

import com.zeun.ddamap.repository.LocationGroupRepository;
import com.zeun.ddamap.repository.StationRepository;
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

        // when
        stationService.updateStationData();

        // then
        Long stationCount = stationRepository.count();
        Long groupCount = locationGroupRepository.count();

        System.out.println("groupCount = " + groupCount);
        System.out.println("stationCount = " + stationCount);

        assert(groupCount > 0);
        assert(stationCount > 0);
    }
}
