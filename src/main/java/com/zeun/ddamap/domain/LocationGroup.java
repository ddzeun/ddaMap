package com.zeun.ddamap.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "location_group")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LocationGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "group_name", nullable = false, unique = true)
    private String groupName;

    public LocationGroup(String groupName) {
        this.groupName = groupName;
    }
}