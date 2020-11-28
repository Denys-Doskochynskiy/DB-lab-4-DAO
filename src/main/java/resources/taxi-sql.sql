CREATE SCHEMA IF NOT EXISTS `four_lab_db` DEFAULT CHARACTER SET utf8;
USE `four_lab_db`;


DROP TABLE IF EXISTS passenger;
DROP TABLE IF EXISTS driver;
DROP TABLE IF EXISTS passenger_taxi_info;
DROP TABLE IF EXISTS driver_taxi_info;
DROP TABLE IF EXISTS license;
DROP TABLE IF EXISTS auto;



CREATE TABLE auto
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    mark        VARCHAR(45) NOT NULL,
    auto_number VARCHAR(45) NOT NULL,
    auto_type   VARCHAR(45) NOT NULL,
    state       VARCHAR(45) NOT NULL
)
    ENGINE = InnoDB;


CREATE TABLE license
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_of_issue  VARCHAR(45) NOT NULL,
    place_of_issue VARCHAR(45) NOT NULL
)
    ENGINE = InnoDB;

CREATE TABLE driver_taxi_info
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    driving_experience FLOAT   NOT NULL,
    rating_driver      FLOAT   NOT NULL,
    license_id         BIGINT  NOT NULL,
    auto_id            BIGINT  NOT NULL,
    is_booked          BOOLEAN NOT NULL
)
    ENGINE = InnoDB;
CREATE INDEX driver_taxi_info1 ON driver_taxi_info (license_id, auto_id);

ALTER TABLE driver_taxi_info
    ADD CONSTRAINT FK_driver_taxi_info_license_id
        FOREIGN KEY (license_id)
            REFERENCES license (id),

    ADD CONSTRAINT FK_driver_taxi_info_auto_id
        FOREIGN KEY (auto_id)
            REFERENCES auto (id);

CREATE TABLE passenger_taxi_info
(
    id                   BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_of_registration VARCHAR(45) NOT NULL,
    taxi_trip_history_id BIGINT      NOT NULL,
    rating               FLOAT       NOT NULL
)
    ENGINE = InnoDB;

CREATE TABLE passenger
(
    id                     BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name             VARCHAR(45) NOT NULL,
    second_name            VARCHAR(45) NOT NULL,
    gender                 VARCHAR(45) NOT NULL,
    date_of_birth          VARCHAR(45) NOT NULL,
    passenger_taxi_info_id BIGINT      NOT NULL
)
    ENGINE = InnoDB;

CREATE INDEX passenger1 ON passenger (passenger_taxi_info_id);

ALTER TABLE passenger
    ADD CONSTRAINT FK_passenger_passenger_taxi_info_id
        FOREIGN KEY (passenger_taxi_info_id)
            REFERENCES passenger_taxi_info (id);


CREATE TABLE driver
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name          VARCHAR(45) NOT NULL,
    second_name         VARCHAR(45) NOT NULL,
    gender              VARCHAR(45) NOT NULL,
    date_of_birth       VARCHAR(45) NOT NULL,
    driver_taxi_info_id BIGINT      NOT NULL
)
    ENGINE = InnoDB;
CREATE INDEX driver1 ON driver (driver_taxi_info_id);

ALTER TABLE driver
    ADD CONSTRAINT FK_driver_driver_taxi_info_id
        FOREIGN KEY (driver_taxi_info_id)
            REFERENCES driver_taxi_info (id);
