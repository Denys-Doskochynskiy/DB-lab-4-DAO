package org.lab.dao.lab_dao.model.entity;


import javax.persistence.*;

@Table(name = "passenger")
@Entity
public class TaxiPassenger {
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
  @JoinColumn(name = "passenger_taxi_info_id", referencedColumnName = "id", nullable = false)
  private PassengerTaxiInfo passengerTaxiInfo;

  public TaxiPassenger(int id, String firstName, String secondName, String gender, String dateOfBirth, PassengerTaxiInfo passengerTaxiInfo) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.passengerTaxiInfo = passengerTaxiInfo;

  }

  public TaxiPassenger(String firstName, String secondName, String gender, String dateOfBirth, PassengerTaxiInfo passengerTaxiInfo) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.passengerTaxiInfo = passengerTaxiInfo;
  }


  public TaxiPassenger() {

  }

  public PassengerTaxiInfo getPassengerTaxiInfo() {
    return passengerTaxiInfo;
  }

  public void setPassengerTaxiInfo(PassengerTaxiInfo passengerTaxiInfo) {
    this.passengerTaxiInfo = passengerTaxiInfo;
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
    return "\n______________________________________________________________________________________________________________________\nPassenger: id: " + id + ", firstName: " + firstName + ", secondName: " + secondName + ", gender: "
        + gender + ", dateOfBirth: " + dateOfBirth + ", passengerTaxiInfoId: " + passengerTaxiInfo
        + "]\n______________________________________________________________________________________________________________________\n";
  }


}
