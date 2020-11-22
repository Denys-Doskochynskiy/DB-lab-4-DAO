package org.lab.dao.lab_dao.model.entity;

public class License {
    private int id;
    private String dateOfIssue;
    private String placeOfIssue;

    public License(int id, String dateOfIssue, String placeOfIssue) {
        this.id = id;
        this.dateOfIssue = dateOfIssue;
        this.placeOfIssue = placeOfIssue;
    }
    public License( String dateOfIssue, String placeOfIssue) {
        this(-1,dateOfIssue,placeOfIssue);
    }

    @Override
    public String toString() {
        return "\n\nGenre: id: " + id + ", dateOfIssue: " + dateOfIssue + ", placeOfIssue: " + placeOfIssue + "";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }
}
