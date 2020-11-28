package org.lab.dao.lab_dao.model.dao.implementation;


import org.lab.dao.lab_dao.model.dao.GenericDAO;
import org.lab.dao.lab_dao.model.entity.Auto;
import org.lab.dao.lab_dao.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutoDAO implements GenericDAO<Auto> {

  private static final String GET_ALL = "SELECT * FROM four_lab_db.auto";
  private static final String GET_ONE = "SELECT * FROM four_lab_db.auto WHERE id=?";
  private static final String CREATE = "INSERT four_lab_db.auto "
      + "(mark, auto_number, auto_type, state) VALUES (?, ?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE four_lab_db.auto"
      + " SET mark=?, auto_number=?, auto_type=?, state=? WHERE id=?";
  private static final String DELETE = "DELETE FROM four_lab_db.auto WHERE id=?";

  @Override
  public List<Auto> findAll() {
    List<Auto> autos = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Auto auto = new Auto(
            resultSet.getInt("id"),
            resultSet.getString("mark"),
            resultSet.getString("auto_number"),
            resultSet.getString("auto_type"),
            resultSet.getString("state")
        );
        autos.add(auto);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return autos;
  }

  @Override
  public Auto findOne(Integer id) {
    Auto auto = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        auto = new Auto(
            resultSet.getInt("id"),
            resultSet.getString("mark"),
            resultSet.getString("auto_number"),
            resultSet.getString("auto_type"),
            resultSet.getString("state")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return auto;
  }

  @Override
  public void create(Auto auto) throws SQLException {

    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

      statement.setString(1, auto.getMark());
      statement.setString(2, auto.getAutoNumber());
      statement.setString(3, auto.getAutoType());
      statement.setString(4, auto.getState());


      statement.executeUpdate();
      System.out.println(statement);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  @Override
  public void update(Integer id, Auto auto) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {


      statement.setString(1, auto.getMark());
      statement.setString(2, auto.getAutoNumber());
      statement.setString(3, auto.getAutoType());
      statement.setString(4, auto.getState());
      statement.setInt(5, auto.getId());

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