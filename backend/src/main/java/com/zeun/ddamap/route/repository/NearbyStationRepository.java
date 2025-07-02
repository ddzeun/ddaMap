package com.zeun.ddamap.route.repository;

import com.zeun.ddamap.station.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NearbyStationRepository extends JpaRepository<Station, String> {

    @Query(
            value = "SELECT S.STN_ID, S.STN_NO, S.GROUP_ID, S.STN_NAME, S.STN_ADDR1, S.STN_ADDR2, " +
                    "ST_Y(S.LOCATION) LATITUDE, ST_X(S.LOCATION) LONGITUDE, " +
                    "ST_Distance_Sphere(S.LOCATION, ST_PointFromText(:userPoint, 4326)) AS DISTANCE " +
                    "FROM   STATION S " +
                    "WHERE  ST_Distance_Sphere(S.LOCATION, ST_PointFromText(:userPoint, 4326)) <= :radius " +
                    "ORDER BY DISTANCE ASC " +
                    "LIMIT :limit",
            nativeQuery = true
    )

    List<Object[]> findNearbyStationsWithDistance(
            @Param("userPoint") String userPoint,
            @Param("radius") int radius,
            @Param("limit") int limit
    );
}
