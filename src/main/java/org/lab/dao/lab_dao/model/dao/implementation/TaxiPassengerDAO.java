package org.lab.dao.lab_dao.model.dao.implementation;

import org.lab.dao.lab_dao.model.dao.GenericDAO;
import org.lab.dao.lab_dao.model.entity.TaxiPassenger;
import org.lab.dao.lab_dao.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaxiPassengerDAO implements GenericDAO<TaxiPassenger> {

  private static final String GET_ALL = "SELECT * FROM four_lab_db.passenger";
  private static final String GET_ONE = "SELECT * FROM four_lab_db.passenger WHERE id=?";
  private static final String CREATE = "INSERT four_lab_db.passenger "
      + "(first_name, second_name, gender, date_of_birth, passenger_taxi_info_id) VALUES (?, ?, ?, ?,?)";
  private static final String UPDATE = "UPDATE four_lab_db.passenger"
      + " SET first_name=?, second_name=?, gender=?, date_of_birth=?,  passenger_taxi_info_id=? WHERE id=?";
  private static final String DELETE = "DELETE FROM four_lab_db.passenger WHERE id=?";

  @Override
  public List<TaxiPassenger> findAll() {
    List<TaxiPassenger> taxiPassengers = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        TaxiPassenger taxiPassenger = new TaxiPassenger(
            resultSet.getInt("id"),
            resultSet.getString("first_name"),
            resultSet.getString("second_name"),
            resultSet.getString("gender"),
            resultSet.getString("date_of_birth"),
            resultSet.getInt("passenger_taxi_info_id")
        );
        taxiPassengers.add(taxiPassenger);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return taxiPassengers;
  }

  @Override
  public TaxiPassenger findOne(Integer id) {
    TaxiPassenger taxiPassenger = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        taxiPassenger = new TaxiPassenger(
            resultSet.getInt("id"),
            resultSet.getString("first_name"),
            resultSet.getString("second_name"),
            resultSet.getString("gender"),
            resultSet.getString("date_of_birth"),
            resultSet.getInt("passenger_taxi_info_id")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return taxiPassenger;
  }

  @Override
  public void create(TaxiPassenger taxiPassenger) throws SQLException {

    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
      statement.setString(1, taxiPassenger.getFirstName());
      statement.setString(2, taxiPassenger.getSecondName());
      statement.setString(3, taxiPassenger.getGender());
      statement.setString(4, taxiPassenger.getDateOfBirth());
      statement.setInt(5, taxiPassenger.getPassengerTaxiInfoId());


      statement.executeUpdate();
      System.out.println(statement);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  @Override
  public void update(Integer id, TaxiPassenger taxiPassenger) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
      statement.setString(1, taxiPassenger.getFirstName());
      statement.setString(2, taxiPassenger.getSecondName());
      statement.setString(3, taxiPassenger.getGender());
      statement.setString(4, taxiPassenger.getDateOfBirth());
      statement.setInt(5, taxiPassenger.getPassengerTaxiInfoId());
      statement.setInt(6, taxiPassenger.getId());


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