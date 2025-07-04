package com.zeun.ddamap.station.service;

import com.zeun.ddamap.station.domain.LocationGroup;
import com.zeun.ddamap.station.domain.Station;
import com.zeun.ddamap.station.dto.StationResponseDTO;
import com.zeun.ddamap.station.dto.StationRowDTO;
import com.zeun.ddamap.station.repository.LocationGroupRepository;
import com.zeun.ddamap.station.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StationService {

    private final StationApiService stationApiService;
    private final LocationGroupRepository locationGroupRepository;
    private final StationRepository stationRepository;

    @Transactional
    public void updateStationData() {

        final GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
        List<StationRowDTO> stationList = stationApiService.fetchAllStationData();

        stationList.forEach(dto -> {

            LocationGroup locationGroup = locationGroupRepository.findByGroupName(dto.stnLoc())
                    .orElseGet(() -> {
                        LocationGroup newGroup = new LocationGroup(dto.stnLoc());
                        return locationGroupRepository.save(newGroup);
                    });

            Coordinate coordinate = new Coordinate(dto.stnLong().doubleValue(), dto.stnLat().doubleValue());
            Point locationPoint = geometryFactory.createPoint(coordinate);

            Station station = Station.builder()
                    .stnId(dto.stnId())
                    .stnNo(dto.stnNo())
                    .stnName(dto.stnName())
                    .locationGroup(locationGroup)
                    .stnAddr1(dto.stnAddr1())
                    .stnAddr2(dto.stnAddr2())
                    .location(locationPoint)
                    .holdCount(dto.holdCount())
                    .build();

            stationRepository.save(station);
        });
    }

    public List<StationResponseDTO> getAllStations() {

        List<StationResponseDTO> stationList = stationRepository.findAll().stream()
                .map(station -> {

                    Point location = station.getLocation();

                    BigDecimal latitude = BigDecimal.valueOf(location.getY());
                    BigDecimal longitude = BigDecimal.valueOf(location.getX());

                    return new StationResponseDTO(
                            station.getStnId(),
                            station.getStnName(),
                            combineAddress(station.getStnAddr1(), station.getStnAddr2()),
                            latitude,
                            longitude
                    );
                }).toList();

        return stationList;
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