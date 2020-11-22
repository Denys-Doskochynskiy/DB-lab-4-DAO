package org.lab.dao.lab_dao.model.entity;


public class User {
    private int id;
    private String firstName;
    private String secondName;
    private String gender;
    private String dateOfBirth;

    public int getTaxiUserRoleId() {
        return taxiUserRoleId;
    }

    public void setTaxiUserRoleId(int taxiUserRoleId) {
        this.taxiUserRoleId = taxiUserRoleId;
    }

    private int taxiUserRoleId;

    public User(int id, String firstName, String secondName, String gender, String dateOfBirth, int taxiUserRoleId) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.taxiUserRoleId = taxiUserRoleId;
    }

    public User(String firstName, String secondName, String gender, String dateOfBirth, int taxiUserRoleId) {
        this(-1, firstName, secondName, gender, dateOfBirth, taxiUserRoleId);
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
                + gender + ", dateOfBirth: " + dateOfBirth + ", taxiUserRoleId: " + taxiUserRoleId
                + "]";
    }
}
