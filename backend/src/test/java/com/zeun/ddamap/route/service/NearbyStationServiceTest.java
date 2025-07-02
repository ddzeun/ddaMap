package com.zeun.ddamap.route.service;

import com.zeun.ddamap.route.dto.NearbyStationDTO;
import com.zeun.ddamap.route.repository.NearbyStationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("local")
public class NearbyStationServiceTest {

    @Autowired
    private NearbyStationService nearbyStationService;

    @Autowired
    private NearbyStationRepository nearbyStationRepository;

    @Test
    @DisplayName("근접 대여소 검색 기능 테스트")
    public void testFindNearbyStations() {

        // given
        BigDecimal latitude = new BigDecimal(37.497765861271866);
        BigDecimal longitude = new BigDecimal(127.14285899651068);

        // when
        List<NearbyStationDTO> nearbyStationList = nearbyStationService.findNearbyStationsWithDistance(longitude, latitude);

        // then
        System.out.println(nearbyStationList);

        assertThat(nearbyStationList).isNotNull().isNotEmpty();
    }
}
