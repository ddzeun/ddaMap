package com.zeun.ddamap.service;

import com.zeun.ddamap.domain.LocationGroup;
import com.zeun.ddamap.domain.Station;
import com.zeun.ddamap.dto.StationResponseDTO;
import com.zeun.ddamap.dto.StationRowDTO;
import com.zeun.ddamap.repository.LocationGroupRepository;
import com.zeun.ddamap.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StationService {

    private final StationApiService stationApiService;
    private final LocationGroupRepository locationGroupRepository;
    private final StationRepository stationRepository;

    @Transactional
    public void updateStationData() {

        List<StationRowDTO> stationList = stationApiService.fetchStationData().stationInfoDTO().stationList();

        stationList.forEach(dto -> {

            LocationGroup locationGroup = locationGroupRepository.findByGroupName(dto.stnLoc())
                    .orElseGet(() -> {
                        LocationGroup newGroup = new LocationGroup(dto.stnLoc());
                        return locationGroupRepository.save(newGroup);
                    });

            Station station = Station.builder()
                    .stnId(dto.stnId())
                    .stnNo(dto.stnNo())
                    .stnName(dto.stnName())
                    .locationGroup(locationGroup)
                    .stnAddr1(dto.stnAddr1())
                    .stnAddr2(dto.stnAddr2())
                    .stnLat(dto.stnLat())
                    .stnLong(dto.stnLong())
                    .holdCount(dto.holdCount())
                    .build();

            stationRepository.save(station);
        });
    }

    public List<StationResponseDTO> getAllStations() {

        List<StationResponseDTO> stationList = stationRepository.findAll().stream()
                .map(station -> new StationResponseDTO(
                        station.getStnId(),
                        station.getStnName(),
                        combineAddress(station.getStnAddr1(), station.getStnAddr2()),
                        station.getStnLat(),
                        station.getStnLong()
                )).toList();

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