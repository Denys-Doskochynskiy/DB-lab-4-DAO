package org.lab.dao.lab_dao.model.entity;

import javax.persistence.*;

@Table(name = "driver")
@Entity
public class TaxiDriver {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "second_name")
  private String secondName;
  @Column(name = "gender")
  private String gender;
  @Column(name = "date_of_birth")
  private String dateOfBirth;
  @OneToOne
  @JoinColumn(name = "driver_taxi_info_id", referencedColumnName = "id", nullable = false)
  private DriverTaxiInfo driverTaxiInfo;


  public TaxiDriver(int id, String firstName, String secondName, String gender, String dateOfBirth, DriverTaxiInfo driverTaxiInfo) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.driverTaxiInfo = driverTaxiInfo;

  }

  public TaxiDriver(String firstName, String secondName, String gender, String dateOfBirth, DriverTaxiInfo driverTaxiInfo) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.driverTaxiInfo = driverTaxiInfo;

  }

  public TaxiDriver() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }


  @Override
  public String toString() {
    return "\n______________________________________________________________________________________________________________________\nDriver: id: " + id + ", firstName: " + firstName + ", secondName: " + secondName + ", gender: "
        + gender + ", dateOfBirth: " + dateOfBirth + ", driverTaxiInfoId: " + driverTaxiInfo
        + "]\n______________________________________________________________________________________________________________________\n";
  }


  public DriverTaxiInfo getDriverTaxiInfo() {
    return driverTaxiInfo;
  }

  public void setDriverTaxiInfo(DriverTaxiInfo driverTaxiInfo) {
    this.driverTaxiInfo = driverTaxiInfo;
  }
}
