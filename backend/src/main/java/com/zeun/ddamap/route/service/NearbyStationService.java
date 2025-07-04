package com.zeun.ddamap.route.service;

import com.zeun.ddamap.route.repository.NearbyStationRepository;
import com.zeun.ddamap.route.dto.NearbyStationDTO;
import com.zeun.ddamap.station.domain.Station;
import com.zeun.ddamap.station.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NearbyStationService {

    private final NearbyStationRepository nearbyStationRepository;
    private final StationRepository stationRepository; // Station의 상세 정보를 가져오기 위해 주입!

    public List<NearbyStationDTO> findNearbyStationsWithDistance(BigDecimal latitude, BigDecimal longitude) {

        int radius = 1000;
        int limit = 30;

        List<Object[]> idAndDistanceList = nearbyStationRepository.findNearbyStationIds(latitude, longitude, radius, limit);

        List<String> stationIds = idAndDistanceList.stream()
                .map(row -> (String) row[0])
                .collect(Collectors.toList());

        Map<String, Double> distanceMap = idAndDistanceList.stream()
                .collect(Collectors.toMap(
                        row -> (String) row[0],
                        row -> ((Number) row[1]).doubleValue()
                ));

        List<Station> stations = stationRepository.findAllById(stationIds);

        return stations.stream()
                .map(station -> {
                    Point location = station.getLocation();
                    Double distance = distanceMap.get(station.getStnId());

                    return new NearbyStationDTO(
                            station.getStnId(),
                            station.getStnName(),
                            combineAddress(station.getStnAddr1(), station.getStnAddr2()),
                            distance,
                            BigDecimal.valueOf(location.getY()).doubleValue(),
                            BigDecimal.valueOf(location.getX()).doubleValue()
                    );
                })
                .sorted(Comparator.comparing(NearbyStationDTO::distance))
                .collect(Collectors.toList());
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
