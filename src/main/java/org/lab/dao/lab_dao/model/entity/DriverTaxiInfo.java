package org.lab.dao.lab_dao.model.entity;

import javax.persistence.*;

@Table(name = "driver_taxi_info")
@Entity
public class DriverTaxiInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "driving_experience")
  private Float drivingExperience;
  @Column(name = "rating_driver")
  private Float ratingDriver;


  @OneToOne
  @JoinColumn(name = "license_id", referencedColumnName = "id", nullable = false)
  private License license;


  @OneToOne
  @JoinColumn(name = "auto_id", referencedColumnName = "id", nullable = false)
  private Auto auto;

  @Column(name = "is_booked")
  private Boolean isBooked;

  public DriverTaxiInfo(int id, Float drivingExperience, Float ratingDriver, License license, Auto auto, Boolean isBooked) {
    this.id = id;
    this.drivingExperience = drivingExperience;
    this.ratingDriver = ratingDriver;
    this.license = license;
    this.auto = auto;
    this.isBooked = isBooked;
  }

  public DriverTaxiInfo(Float drivingExperience, Float ratingDriver, License license, Auto auto, Boolean isBooked) {
    this.drivingExperience = drivingExperience;
    this.ratingDriver = ratingDriver;
    this.license = license;
    this.auto = auto;
    this.isBooked = isBooked;
  }

  public DriverTaxiInfo() {

  }

  @Override
  public String toString() {
    return "\n______________________________________________________________________________________________________________________\nDriverTaxiInfo: id: " + id + ", drivingExperience: " + drivingExperience + ", ratingDriver: " + ratingDriver + ", licenseId: "
        + license + ", autoId: " + auto + ", isBooked: " + isBooked
        + "]\n______________________________________________________________________________________________________________________\n";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Float getDrivingExperience() {
    return drivingExperience;
  }

  public void setDrivingExperience(Float drivingExperience) {
    this.drivingExperience = drivingExperience;
  }

  public Float getRatingDriver() {
    return ratingDriver;
  }

  public void setRatingDriver(Float ratingDriver) {
    this.ratingDriver = ratingDriver;
  }


  public Boolean getBooked() {
    return isBooked;
  }

  public void setBooked(Boolean booked) {
    isBooked = booked;
  }

  public Auto getAuto() {
    return auto;
  }

  public void setAuto(Auto auto) {
    this.auto = auto;
  }

  public License getLicense() {
    return license;
  }

  public void setLicense(License license) {
    this.license = license;
  }
}

