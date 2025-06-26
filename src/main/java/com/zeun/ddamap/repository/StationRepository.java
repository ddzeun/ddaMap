package com.zeun.ddamap.repository;

import com.zeun.ddamap.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, String> {
}
