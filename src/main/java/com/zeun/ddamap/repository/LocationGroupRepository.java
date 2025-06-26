package com.zeun.ddamap.repository;

import com.zeun.ddamap.domain.LocationGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationGroupRepository extends JpaRepository<LocationGroup, Long> {

    Optional<LocationGroup> findByGroupName(String groupName);
}
