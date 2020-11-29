package org.lab.dao.lab_dao.model.entity;

import javax.persistence.*;

@Table(name = "passenger_taxi_info")
@Entity
public class PassengerTaxiInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "date_of_registration")
  private String dateOfRegistration;
  @Column(name = "taxi_trip_history_id")
  private int taxiTripHistoryId;
  @Column(name = "rating")
  private Float rating;


  public PassengerTaxiInfo(int id, String dateOfRegistration, int taxiTripHistoryId, Float rating) {
    this.id = id;
    this.dateOfRegistration = dateOfRegistration;
    this.taxiTripHistoryId = taxiTripHistoryId;
    this.rating = rating;
  }

  public PassengerTaxiInfo(String dateOfRegistration, int taxiTripHistoryId, Float rating) {
    this.dateOfRegistration = dateOfRegistration;
    this.taxiTripHistoryId = taxiTripHistoryId;
    this.rating = rating;
  }

  public PassengerTaxiInfo() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDateOfRegistration() {
    return dateOfRegistration;
  }

  public void setDateOfRegistration(String dateOfRegistration) {
    this.dateOfRegistration = dateOfRegistration;
  }

  public int getTaxiTripHistoryId() {
    return taxiTripHistoryId;
  }

  public void setTaxiTripHistoryId(int taxiTripHistoryId) {
    this.taxiTripHistoryId = taxiTripHistoryId;
  }

  public Float getRating() {
    return rating;
  }

  public void setRating(Float rating) {
    this.rating = rating;
  }

  @Override
  public String toString() {
    return "\n\nPassengerTaxiInfo: id: " + id + ", dateOfRegistration: " + dateOfRegistration + ", taxiTripHistoryId: " + taxiTripHistoryId + ", rating: " + rating + "";
  }
}
