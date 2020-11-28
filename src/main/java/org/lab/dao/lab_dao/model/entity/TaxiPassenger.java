package org.lab.dao.lab_dao.model.entity;

public class TaxiPassenger {
  private int id;
  private String firstName;
  private String secondName;
  private String gender;
  private String dateOfBirth;
  private int passengerTaxiInfoId;


  public TaxiPassenger(int id, String firstName, String secondName, String gender, String dateOfBirth, int passengerTaxiInfoId) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.passengerTaxiInfoId = passengerTaxiInfoId;

  }

  public TaxiPassenger(String firstName, String secondName, String gender, String dateOfBirth, int passengerTaxiInfoId) {
    this(-1, firstName, secondName, gender, dateOfBirth, passengerTaxiInfoId);
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
        + gender + ", dateOfBirth: " + dateOfBirth + ", passengerTaxiInfoId: " + passengerTaxiInfoId
        + "]";
  }

  public int getPassengerTaxiInfoId() {
    return passengerTaxiInfoId;
  }

  public void setPassengerTaxiInfoId(int passengerTaxiInfoId) {
    this.passengerTaxiInfoId = passengerTaxiInfoId;
  }
}
