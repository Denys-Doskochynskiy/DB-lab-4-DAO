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

    private static final String GET_ALL = "SELECT * FROM third_lab_db.taxi_passenger";
    private static final String GET_ONE = "SELECT * FROM third_lab_db.taxi_passenger WHERE id=?";
    private static final String CREATE = "INSERT third_lab_db.taxi_passenger "
            + "(date_of_registration, taxi_trip_history_id, rating) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE third_lab_db.taxi_passenger"
            + " SET date_of_registration=?, taxi_trip_history_id=?, rating=? WHERE id=?";
    private static final String DELETE = "DELETE FROM third_lab_db.taxi_passenger WHERE id=?";

    @Override
    public List<TaxiPassenger> findAll() {
        List<TaxiPassenger> taxiPassengers = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TaxiPassenger taxiPassenger = new TaxiPassenger(
                        resultSet.getInt("id"),
                        resultSet.getString("date_of_registration"),
                        resultSet.getInt("taxi_trip_history_id"),
                        resultSet.getFloat("rating")
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
                        resultSet.getString("date_of_registration"),
                        resultSet.getInt("taxi_trip_history_id"),
                        resultSet.getFloat("rating")
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
            statement.setString(1, taxiPassenger.getDateOfRegistration());
            statement.setInt(2, taxiPassenger.getTaxiTripHistoryId());

            statement.setFloat(3, taxiPassenger.getRating());


            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, TaxiPassenger taxiPassenger) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {


            statement.setString(1, taxiPassenger.getDateOfRegistration());
            statement.setInt(2, taxiPassenger.getTaxiTripHistoryId());

            statement.setFloat(3, taxiPassenger.getRating());

            statement.setInt(4, taxiPassenger.getId());

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