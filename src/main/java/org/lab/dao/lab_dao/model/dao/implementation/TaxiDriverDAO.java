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

    private static final String GET_ALL = "SELECT * FROM third_lab_db.taxi_driver";
    private static final String GET_ONE = "SELECT * FROM third_lab_db.taxi_driver WHERE id=?";
    private static final String CREATE = "INSERT third_lab_db.taxi_driver "
            + "(driving_experience, rating_driver, license_id, auto_id,is_booked) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE third_lab_db.taxi_driver"
            + " SET driving_experience=?, rating_driver=?, license_id=?, auto_id=?,is_booked=? WHERE id=?";
    private static final String DELETE = "DELETE FROM third_lab_db.taxi_driver WHERE id=?";

    @Override
    public List<TaxiDriver> findAll() {
        List<TaxiDriver> taxiDrivers = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TaxiDriver taxiDriver = new TaxiDriver(
                        resultSet.getInt("id"),
                        resultSet.getFloat("driving_experience"),
                        resultSet.getFloat("rating_driver"),
                        resultSet.getInt("license_id"),
                        resultSet.getInt("auto_id"),
                        resultSet.getBoolean("is_booked")
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
        return taxiDriver;
    }

    @Override
    public void create(TaxiDriver taxiDriver) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setFloat(1, taxiDriver.getDrivingExperience());
            statement.setFloat(2, taxiDriver.getRatingDriver());
            statement.setInt(3, taxiDriver.getLicenseId());
            statement.setInt(4, taxiDriver.getAutoId());
            statement.setBoolean(5, taxiDriver.getBooked());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, TaxiDriver taxiDriver) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {


            statement.setFloat(1, taxiDriver.getDrivingExperience());
            statement.setFloat(2, taxiDriver.getRatingDriver());
            statement.setInt(3, taxiDriver.getLicenseId());
            statement.setInt(4, taxiDriver.getAutoId());
            statement.setBoolean(5, taxiDriver.getBooked());
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