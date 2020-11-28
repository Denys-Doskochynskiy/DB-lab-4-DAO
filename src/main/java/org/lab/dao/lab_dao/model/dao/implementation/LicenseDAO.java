package org.lab.dao.lab_dao.model.dao.implementation;

import org.lab.dao.lab_dao.model.dao.GenericDAO;
import org.lab.dao.lab_dao.model.entity.License;
import org.lab.dao.lab_dao.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LicenseDAO implements GenericDAO<License> {

  private static final String GET_ALL = "SELECT * FROM four_lab_db.license";
  private static final String GET_ONE = "SELECT * FROM four_lab_db.license WHERE id=?";
  private static final String CREATE = "INSERT four_lab_db.license "
      + "(date_of_issue,  place_of_issue) VALUES (?, ?)";
  private static final String UPDATE = "UPDATE four_lab_db.license"
      + " SET date_of_issue=?, place_of_issue=? WHERE id=?";
  private static final String DELETE = "DELETE FROM four_lab_db.license WHERE id=?";

  @Override
  public List<License> findAll() {
    List<License> licenses = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        License license = new License(
            resultSet.getInt("id"),
            resultSet.getString("date_of_issue"),
            resultSet.getString("place_of_issue")
        );
        licenses.add(license);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return licenses;
  }

  @Override
  public License findOne(Integer id) {
    License license = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        license = new License(
            resultSet.getInt("id"),
            resultSet.getString("date_of_issue"),
            resultSet.getString("place_of_issue")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return license;
  }

  @Override
  public void create(License license) throws SQLException {

    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
      statement.setString(1, license.getDateOfIssue());
      statement.setString(2, license.getPlaceOfIssue());

      statement.executeUpdate();
      System.out.println(statement);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  @Override
  public void update(Integer id, License license) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {


      statement.setString(1, license.getDateOfIssue());
      statement.setString(2, license.getPlaceOfIssue());
      statement.setInt(3, license.getId());

      statement.executeUpdate();
      System.out.println(statement);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(DELETE)) {
      statement.setInt(1, id);
      System.out.println(statement);
      statement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
