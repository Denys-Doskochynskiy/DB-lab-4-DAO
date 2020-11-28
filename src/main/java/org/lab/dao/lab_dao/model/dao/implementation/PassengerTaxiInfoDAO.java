package org.lab.dao.lab_dao.model.dao.implementation;

import org.lab.dao.lab_dao.model.dao.GenericDAO;
import org.lab.dao.lab_dao.model.entity.PassengerTaxiInfo;
import org.lab.dao.lab_dao.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerTaxiInfoDAO implements GenericDAO<PassengerTaxiInfo> {

  private static final String GET_ALL = "SELECT * FROM four_lab_db.passenger_taxi_info";
  private static final String GET_ONE = "SELECT * FROM four_lab_db.passenger_taxi_info WHERE id=?";
  private static final String CREATE = "INSERT four_lab_db.passenger_taxi_info "
      + "(date_of_registration, taxi_trip_history_id, rating) VALUES (?, ?, ?)";
  private static final String UPDATE = "UPDATE four_lab_db.passenger_taxi_info"
      + " SET date_of_registration=?, taxi_trip_history_id=?, rating=? WHERE id=?";
  private static final String DELETE = "DELETE FROM four_lab_db.passenger_taxi_info WHERE id=?";

  @Override
  public List<PassengerTaxiInfo> findAll() {
    List<PassengerTaxiInfo> passengerTaxiInfos = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        PassengerTaxiInfo passengerTaxiInfo = new PassengerTaxiInfo(

            resultSet.getInt("id"),
            resultSet.getString("date_of_registration"),
            resultSet.getInt("taxi_trip_history_id"),
            resultSet.getFloat("rating")
        );
        passengerTaxiInfos.add(passengerTaxiInfo);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return passengerTaxiInfos;
  }

  @Override
  public PassengerTaxiInfo findOne(Integer id) {
    PassengerTaxiInfo passengerTaxiInfo = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        passengerTaxiInfo = new PassengerTaxiInfo(
            resultSet.getInt("id"),
            resultSet.getString("date_of_registration"),
            resultSet.getInt("taxi_trip_history_id"),
            resultSet.getFloat("rating")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return passengerTaxiInfo;
  }

  @Override
  public void create(PassengerTaxiInfo passengerTaxiInfo) throws SQLException {

    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

      statement.setString(1, passengerTaxiInfo.getDateOfRegistration());
      statement.setInt(2, passengerTaxiInfo.getTaxiTripHistoryId());
      statement.setFloat(3, passengerTaxiInfo.getRating());

      statement.executeUpdate();
      System.out.println(statement);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  @Override
  public void update(Integer id, PassengerTaxiInfo passengerTaxiInfo) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

      statement.setString(1, passengerTaxiInfo.getDateOfRegistration());
      statement.setInt(2, passengerTaxiInfo.getTaxiTripHistoryId());
      statement.setFloat(3, passengerTaxiInfo.getRating());

      statement.setInt(4, passengerTaxiInfo.getId());

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