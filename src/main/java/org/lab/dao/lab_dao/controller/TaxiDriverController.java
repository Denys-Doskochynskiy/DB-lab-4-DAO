package org.lab.dao.lab_dao.controller;

import org.lab.dao.lab_dao.model.dao.implementation.TaxiDriverDAO;
import org.lab.dao.lab_dao.model.entity.TaxiDriver;

import java.sql.SQLException;
import java.util.List;

public class TaxiDriverController implements GenericController<TaxiDriver> {

  TaxiDriverDAO dao = new TaxiDriverDAO();

  @Override
  public List<TaxiDriver> findAll() throws SQLException {
    return dao.findAll();
  }

  @Override
  public TaxiDriver findOne(Integer id) throws SQLException {
    return dao.findOne(id);
  }

  @Override
  public void create(TaxiDriver entity) throws SQLException {
    dao.create(entity);
  }

  @Override
  public void update(Integer id, TaxiDriver entity) throws SQLException {
    dao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);

  }

}