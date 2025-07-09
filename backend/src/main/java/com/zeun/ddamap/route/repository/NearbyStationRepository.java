package com.zeun.ddamap.route.repository;

import com.zeun.ddamap.station.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface NearbyStationRepository extends JpaRepository<Station, String> {

    // id와 거리만 반환
    @Query(
            value = "SELECT     s.stn_id, ST_Distance_Sphere(s.location, ST_SRID(POINT(:longitude, :latitude), 4326)) as distance " +
                    "FROM       station s " +
                    "WHERE      ST_Distance_Sphere(s.location, ST_SRID(POINT(:longitude, :latitude), 4326)) <= :radius " +
                    "ORDER BY distance ASC " +
                    "LIMIT :limit",
            nativeQuery = true
    )
    List<Object[]> findNearbyStationIds(
                                         @Param("latitude") BigDecimal latitude,
                                         @Param("longitude") BigDecimal longitude,
                                         @Param("radius") int radius,
                                         @Param("limit") int limit
    );
}