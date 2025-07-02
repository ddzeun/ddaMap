package com.zeun.ddamap.route.service;

import com.zeun.ddamap.route.repository.NearbyStationRepository;
import com.zeun.ddamap.route.dto.NearbyStationDTO;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NearbyStationService {

    private final NearbyStationRepository nearbyStationRepository;

    public List<NearbyStationDTO> findNearbyStationsWithDistance(BigDecimal lng, BigDecimal lat) {

        String userPoint = String.format("POINT(%s %s)", lat, lng);
        int radius = 1000;
        int limit = 10;

        List<Object[]> results = nearbyStationRepository.findNearbyStationsWithDistance(userPoint, radius, limit);

        return results.stream()
                .map(row -> {
                    return new NearbyStationDTO(
                            (String) row[0],
                            (String) row[3],
                            combineAddress((String) row[4], (String) row[5]),
                            ((Number) row[8]).doubleValue(),
                            (Double) row[6],
                            (Double) row[7]
                    );
                })
                .collect(Collectors.toList()); // toList()로 변경
    }

    private String combineAddress(String addr1, String addr2) {

        String address1 = (addr1 == null) ? "" : addr1.trim();
        String address2 = (addr2 == null) ? "" : addr2.trim();

        if (!address1.isEmpty() && !address2.isEmpty()) {

            return address1 + " " + address2;
        }
        return address1 + address2;
    }
}
