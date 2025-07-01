-- CREATE DATABASE ddamap_db
-- DEFAULT CHARSET=utf8mb4
-- COLLATE=utf8mb4_unicode_ci;
--
-- USE ddamap_db;

DROP TABLE IF EXISTS station;
DROP TABLE IF EXISTS location_group;

CREATE TABLE location_group (
                                group_id    BIGINT             NOT NULL    AUTO_INCREMENT,
                                group_name  VARCHAR(50)     NOT NULL,
                                PRIMARY KEY (group_id)
) ENGINE=InnoDB

CREATE TABLE station (
                        stn_id      VARCHAR(50)     NOT NULL,
                        stn_no      VARCHAR(50)     NULL,
                        group_id    BIGINT             NULL,
                        stn_name    VARCHAR(100)    NOT NULL,
                        stn_addr1   VARCHAR(255)    NULL,
                        stn_addr2   VARCHAR(255)    NULL,
                        location    POINT NOT NULL SRID 4326,
                        hold_count  INT             NULL,
                        SPATIAL INDEX(location),
                        PRIMARY KEY (stn_id),
                        FOREIGN KEY (group_id) REFERENCES location_group (group_id)
) ENGINE=InnoDB