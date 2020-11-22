CREATE SCHEMA IF NOT EXISTS `third_lab_db` DEFAULT CHARACTER SET utf8 ;
USE `third_lab_db` ;

DROP TABLE IF EXISTs taxi_user;
DROP TABLE IF EXISTs taxi_user_role;
DROP TABLE IF EXISTS taxi_passenger;
DROP TABLE IF EXISTS taxi_driver;
DROP TABLE IF EXISTS license;
DROP TABLE IF EXISTS auto;



CREATE TABLE auto (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      mark VARCHAR(45) NOT NULL,
                      auto_number VARCHAR(45) NOT NULL,
                      auto_type VARCHAR(45) NOT NULL,
                      state VARCHAR(45) NOT NULL)
    ENGINE = InnoDB;


CREATE TABLE license (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         date_of_issue VARCHAR(45) NOT NULL,
                         place_of_issue VARCHAR(45) NOT NULL)
    ENGINE = InnoDB;

CREATE TABLE taxi_driver(
                            id BIGINT AUTO_INCREMENT PRIMARY KEY ,
                            driving_experience FLOAT NOT NULL,
                            rating_driver FLOAT NOT NULL,
                            license_id BIGINT NOT NULL,
                            auto_id BIGINT NOT NULL,
                            is_booked BOOLEAN NOT NULL
)
    ENGINE = InnoDB;
CREATE INDEX taxi_driver1 ON taxi_driver (license_id,auto_id);

ALTER TABLE taxi_driver
    ADD CONSTRAINT FK_taxi_driver_license_id
        FOREIGN KEY  (license_id)
            REFERENCES license (id),

    ADD CONSTRAINT FK_taxi_driver_auto_id
        FOREIGN KEY  (auto_id)
            REFERENCES auto (id);

CREATE TABLE taxi_passenger(
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               date_of_registration VARCHAR(45) NOT NULL,
                               taxi_trip_history_id BIGINT NOT NULL,
                               rating FLOAT NOT NULL
)
    ENGINE = InnoDB;



CREATE TABLE taxi_user_role (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                taxi_driver_id BIGINT ,
                                taxi_passenger_id BIGINT NOT NULL )
    ENGINE = InnoDB;
CREATE INDEX taxi_user_role1 ON taxi_user_role (taxi_driver_id,taxi_passenger_id);
ALTER TABLE taxi_user_role
    ADD CONSTRAINT FK_taxi_user_role_taxi_driver_id
        FOREIGN KEY (taxi_driver_id)
            REFERENCES taxi_driver(id),

    ADD CONSTRAINT FK_taxi_user_role_taxi_passenger_id
        FOREIGN KEY (taxi_passenger_id)
            REFERENCES taxi_passenger (id);


CREATE TABLE taxi_user (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           first_name VARCHAR(45) NOT NULL,
                           second_name VARCHAR(45) NOT NULL,
                           gender VARCHAR(45) NOT NULL,
                           date_of_birth VARCHAR(45) NOT NULL,
                           taxi_user_role_id BIGINT NOT NULL
)
    ENGINE = InnoDB;
ALTER TABLE taxi_user
    ADD CONSTRAINT FK_taxi_user_taxi_user_role_id
        FOREIGN KEY (taxi_user_role_id)
            REFERENCES taxi_user_role(id) ;