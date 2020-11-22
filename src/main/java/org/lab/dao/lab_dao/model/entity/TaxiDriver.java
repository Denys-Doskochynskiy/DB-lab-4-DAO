package org.lab.dao.lab_dao.model.entity;

public class TaxiDriver {
    private int id;
    private Float drivingExperience;
    private Float ratingDriver;
    private int licenseId;
    private int autoId;
    private Boolean isBooked;

    public TaxiDriver(int id, Float drivingExperience, Float ratingDriver, int licenseId, int autoId, Boolean isBooked) {
        this.id = id;
        this.drivingExperience = drivingExperience;
        this.ratingDriver = ratingDriver;
        this.licenseId = licenseId;
        this.autoId = autoId;
        this.isBooked = isBooked;
    }

    @Override
    public String toString() {
        return "\n\nUser: id: " + id + ", drivingExperience: " + drivingExperience + ", ratingDriver: " + ratingDriver + ", licenseId: "
                + licenseId + ", autoId: " + autoId + ", isBooked: " + isBooked
                + "]";
    }

    public TaxiDriver(Float drivingExperience, Float ratingDriver, int licenseId, int autoId, Boolean isBooked) {
        this(-1, drivingExperience, ratingDriver, licenseId, autoId, isBooked);
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

    public int getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }
}
