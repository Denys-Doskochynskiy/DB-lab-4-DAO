package org.lab.dao.lab_dao.model.dao.implementation;

import org.lab.dao.lab_dao.model.dao.GenericDAO;
import org.lab.dao.lab_dao.model.entity.UserRole;
import org.lab.dao.lab_dao.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRoleDAO implements GenericDAO<UserRole> {

    private static final String GET_ALL = "SELECT * FROM third_lab_db.taxi_user_role";
    private static final String GET_ONE = "SELECT * FROM third_lab_db.taxi_user_role WHERE id=?";
    private static final String CREATE = "INSERT third_lab_db.taxi_user_role "
            + "(taxi_driver_id,  taxi_passenger_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE third_lab_db.taxi_user_role"
            + " SET taxi_driver_id=?, taxi_passenger_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM third_lab_db.taxi_user_role WHERE id=?";

    @Override
    public List<UserRole> findAll() {
        List<UserRole> userRoles = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserRole userRole = new UserRole(
                        resultSet.getInt("id"),
                        resultSet.getInt("taxi_driver_id"),
                        resultSet.getInt("taxi_passenger_id")
                );
                userRoles.add(userRole);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userRoles;
    }

    @Override
    public UserRole findOne(Integer id) {
        UserRole userRole = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                userRole = new UserRole(
                        resultSet.getInt("id"),
                        resultSet.getInt("taxi_driver_id"),
                        resultSet.getInt("taxi_passenger_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userRole;
    }

    @Override
    public void create(UserRole userRole) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

           // statement.setInt(1, userRole.getId());
            statement.setInt(1, userRole.getDriverId());
            statement.setInt(2, userRole.getPassengerId());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, UserRole userRole) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {


            statement.setInt(1,userRole.getDriverId());
            statement.setInt(2, userRole.getPassengerId());

            statement.setInt(32, userRole.getId());

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