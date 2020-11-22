package org.lab.dao.lab_dao.model.dao.implementation;

import org.lab.dao.lab_dao.model.dao.GenericDAO;
import org.lab.dao.lab_dao.model.entity.User;
import org.lab.dao.lab_dao.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements GenericDAO<User> {

    private static final String GET_ALL = "SELECT * FROM third_lab_db.taxi_user";
    private static final String GET_ONE = "SELECT * FROM third_lab_db.taxi_user WHERE id=?";
    private static final String CREATE = "INSERT third_lab_db.taxi_user "
            + "(first_name, second_name, gender, date_of_birth,taxi_user_role_id) VALUES (?, ?, ?, ?,?)";
    private static final String UPDATE = "UPDATE third_lab_db.taxi_user"
            + " SET first_name=?, second_name=?, gender=?, date_of_birth=?, taxi_user_role_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM third_lab_db.taxi_user WHERE id=?";

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getString("gender"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getInt("taxi_user_role_id")
                );
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findOne(Integer id) {
        User user = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getString("gender"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getInt("taxi_user_role_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void create(User user) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1,user.getFirstName());
            statement.setString(2, user.getSecondName());
            statement.setString(3,user.getGender());
            statement.setString(4, user.getDateOfBirth());
            statement.setInt(5, user.getTaxiUserRoleId());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, User user) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {


            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getSecondName());
            statement.setString(3, user.getGender());
            statement.setString(4, user.getDateOfBirth());
            statement.setInt(5, user.getTaxiUserRoleId());
            statement.setInt(6, user.getId());

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