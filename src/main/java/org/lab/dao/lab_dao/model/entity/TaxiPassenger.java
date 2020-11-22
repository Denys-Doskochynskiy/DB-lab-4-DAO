package org.lab.dao.lab_dao.model.entity;

public class TaxiPassenger {
    private int id;
    private String dateOfRegistration;
    private int taxiTripHistoryId;
    private Float rating;


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

    public TaxiPassenger(int id, String dateOfRegistration, int taxiTripHistoryId, Float rating) {
        this.id = id;
        this.dateOfRegistration = dateOfRegistration;
        this.taxiTripHistoryId = taxiTripHistoryId;
        this.rating = rating;
    }

    public TaxiPassenger(String dateOfRegistration, int taxiTripHistoryId, Float rating) {
        this(-1, dateOfRegistration, taxiTripHistoryId, rating);
    }

    @Override
    public String toString() {
        return "\n\nGenre: id: " + id + ", dateOfRegistration: " + dateOfRegistration + ", taxiTripHistoryId: " + taxiTripHistoryId + ", rating: " + rating + "";
    }
}
