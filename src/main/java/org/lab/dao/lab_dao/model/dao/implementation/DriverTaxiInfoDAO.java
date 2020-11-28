package org.lab.dao.lab_dao.model.dao.implementation;

import org.lab.dao.lab_dao.model.dao.GenericDAO;
import org.lab.dao.lab_dao.model.entity.DriverTaxiInfo;
import org.lab.dao.lab_dao.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverTaxiInfoDAO implements GenericDAO<DriverTaxiInfo> {

  private static final String GET_ALL = "SELECT * FROM four_lab_db.driver_taxi_info";
  private static final String GET_ONE = "SELECT * FROM four_lab_db.driver_taxi_info WHERE id=?";
  private static final String CREATE = "INSERT four_lab_db.driver_taxi_info "
      + "(driving_experience, rating_driver, license_id, auto_id,is_booked) VALUES (?, ?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE four_lab_db.driver_taxi_info"
      + " SET driving_experience=?, rating_driver=?, license_id=?, auto_id=?,is_booked=? WHERE id=?";
  private static final String DELETE = "DELETE FROM four_lab_db.driver_taxi_info WHERE id=?";

  @Override
  public List<DriverTaxiInfo> findAll() {
    List<DriverTaxiInfo> driverTaxiInfos = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        DriverTaxiInfo driverTaxiInfo = new DriverTaxiInfo(
            resultSet.getInt("id"),
            resultSet.getFloat("driving_experience"),
            resultSet.getFloat("rating_driver"),
            resultSet.getInt("license_id"),
            resultSet.getInt("auto_id"),
            resultSet.getBoolean("is_booked")
        );
        driverTaxiInfos.add(driverTaxiInfo);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return driverTaxiInfos;
  }

  @Override
  public DriverTaxiInfo findOne(Integer id) {
    DriverTaxiInfo driverTaxiInfo = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        driverTaxiInfo = new DriverTaxiInfo(
            resultSet.getInt("id"),
            resultSet.getFloat("driving_experience"),
            resultSet.getFloat("rating_driver"),
            resultSet.getInt("license_id"),
            resultSet.getInt("auto_id"),
            resultSet.getBoolean("is_booked")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return driverTaxiInfo;
  }

  @Override
  public void create(DriverTaxiInfo driverTaxiInfo) throws SQLException {

    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

      statement.setFloat(1, driverTaxiInfo.getDrivingExperience());
      statement.setFloat(2, driverTaxiInfo.getRatingDriver());
      statement.setInt(3, driverTaxiInfo.getLicenseId());
      statement.setInt(4, driverTaxiInfo.getAutoId());
      statement.setBoolean(5, driverTaxiInfo.getBooked());

      statement.executeUpdate();
      System.out.println(statement);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  @Override
  public void update(Integer id, DriverTaxiInfo driverTaxiInfo) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

      statement.setFloat(1, driverTaxiInfo.getDrivingExperience());
      statement.setFloat(2, driverTaxiInfo.getRatingDriver());
      statement.setInt(3, driverTaxiInfo.getLicenseId());
      statement.setInt(4, driverTaxiInfo.getAutoId());
      statement.setBoolean(5, driverTaxiInfo.getBooked());

      statement.setInt(6, driverTaxiInfo.getId());

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