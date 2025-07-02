package com.zeun.ddamap.station.domain;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

import java.math.BigDecimal;

@Entity
@Table(name = "station")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Station {

    @Id
    @Column(name = "stn_id")
    private String stnId;

    @Column(name = "stn_no")
    private String stnNo;

    @Column(name = "stn_name", nullable = false)
    private String stnName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private LocationGroup locationGroup;

    @Column(name = "stn_addr1")
    private String stnAddr1;

    @Column(name = "stn_addr2")
    private String stnAddr2;

    @Column(name = "location", nullable = false, columnDefinition = "POINT")
    private Point location;

    @Column(name = "hold_count")
    private Integer holdCount;
}