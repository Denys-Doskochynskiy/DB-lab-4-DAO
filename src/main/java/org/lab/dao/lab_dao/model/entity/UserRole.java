package org.lab.dao.lab_dao.model.entity;

public class UserRole {
    private int id;
    private int driverId;
    private int passengerId;

    public UserRole(int id, int driverId, int passengerId) {
        this.id = id;
        this.driverId = driverId;
        this.passengerId = passengerId;
    }

    public UserRole(int driverId, int passengerId) {
        this(-1, driverId, passengerId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    @Override
    public String toString() {
        return "\n\nUser role: id: " + id + ", driverId: " + driverId + ", passengerId: " + passengerId + "";
    }

}

