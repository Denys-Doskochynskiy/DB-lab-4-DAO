package org.lab.dao.lab_dao.model.dao.implementation;

import org.lab.dao.lab_dao.model.dao.GenericDAO;
import org.lab.dao.lab_dao.model.entity.TaxiDriver;
import org.lab.dao.lab_dao.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaxiDriverDAO implements GenericDAO<TaxiDriver> {

  private static final String GET_ALL = "SELECT * FROM four_lab_db.driver";
  private static final String GET_ONE = "SELECT * FROM four_lab_db.driver WHERE id=?";
  private static final String CREATE = "INSERT four_lab_db.driver "
      + "(first_name, second_name, gender, date_of_birth, driver_taxi_info_id) VALUES (?, ?, ?, ?,?)";
  private static final String UPDATE = "UPDATE four_lab_db.driver"
      + " SET first_name=?, second_name=?, gender=?, date_of_birth=?,  driver_taxi_info_id=? WHERE id=?";
  private static final String DELETE = "DELETE FROM four_lab_db.driver WHERE id=?";

  @Override
  public List<TaxiDriver> findAll() {
    List<TaxiDriver> taxiDrivers = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        TaxiDriver taxiDriver = new TaxiDriver(
            resultSet.getInt("id"),
            resultSet.getString("first_name"),
            resultSet.getString("second_name"),
            resultSet.getString("gender"),
            resultSet.getString("date_of_birth"),
            resultSet.getInt("driver_taxi_info_id")
        );
        taxiDrivers.add(taxiDriver);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return taxiDrivers;
  }

  @Override
  public TaxiDriver findOne(Integer id) {
    TaxiDriver taxiDriver = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        taxiDriver = new TaxiDriver(
            resultSet.getInt("id"),
            resultSet.getString("first_name"),
            resultSet.getString("second_name"),
            resultSet.getString("gender"),
            resultSet.getString("date_of_birth"),
            resultSet.getInt("driver_taxi_info_id")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return taxiDriver;
  }

  @Override
  public void create(TaxiDriver taxiDriver) throws SQLException {

    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

      statement.setString(1, taxiDriver.getFirstName());
      statement.setString(2, taxiDriver.getSecondName());
      statement.setString(3, taxiDriver.getGender());
      statement.setString(4, taxiDriver.getDateOfBirth());
      statement.setInt(5, taxiDriver.getDriverTaxiInfoId());

      statement.executeUpdate();
      System.out.println(statement);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  @Override
  public void update(Integer id, TaxiDriver taxiDriver) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

      statement.setString(1, taxiDriver.getFirstName());
      statement.setString(2, taxiDriver.getSecondName());
      statement.setString(3, taxiDriver.getGender());
      statement.setString(4, taxiDriver.getDateOfBirth());
      statement.setInt(5, taxiDriver.getDriverTaxiInfoId());
      statement.setInt(6, taxiDriver.getId());
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