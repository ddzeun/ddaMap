package com.zeun.ddamap.station.repository;

import com.zeun.ddamap.station.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, String> {
}
