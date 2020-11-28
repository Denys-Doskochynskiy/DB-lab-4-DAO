package org.lab.dao.lab_dao.model.entity;

public class TaxiDriver {
  private int id;
  private String firstName;
  private String secondName;
  private String gender;
  private String dateOfBirth;
  private int driverTaxiInfoId;


  public TaxiDriver(int id, String firstName, String secondName, String gender, String dateOfBirth, int driverTaxiInfoId) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.driverTaxiInfoId = driverTaxiInfoId;

  }

  public TaxiDriver(String firstName, String secondName, String gender, String dateOfBirth, int driverTaxiInfoId) {
    this(-1, firstName, secondName, gender, dateOfBirth, driverTaxiInfoId);
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
    return "\n\nUser: id: " + id + ", firstName: " + firstName + ", secondName: " + secondName + ", gender: "
        + gender + ", dateOfBirth: " + dateOfBirth + ", driverTaxiInfoId: " + driverTaxiInfoId
        + "]";
  }

  public int getDriverTaxiInfoId() {
    return driverTaxiInfoId;
  }

  public void setDriverTaxiInfoId(int driverTaxiInfoId) {
    this.driverTaxiInfoId = driverTaxiInfoId;
  }
}
