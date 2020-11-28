package org.lab.dao.lab_dao.controller;

import org.lab.dao.lab_dao.model.dao.implementation.DriverTaxiInfoDAO;
import org.lab.dao.lab_dao.model.entity.DriverTaxiInfo;

import java.sql.SQLException;
import java.util.List;

public class DriverTaxiInfoController implements GenericController<DriverTaxiInfo> {

  DriverTaxiInfoDAO dao = new DriverTaxiInfoDAO();

  @Override
  public List<DriverTaxiInfo> findAll() throws SQLException {
    return dao.findAll();
  }

  @Override
  public DriverTaxiInfo findOne(Integer id) throws SQLException {
    return dao.findOne(id);
  }

  @Override
  public void create(DriverTaxiInfo entity) throws SQLException {
    dao.create(entity);
  }

  @Override
  public void update(Integer id, DriverTaxiInfo entity) throws SQLException {
    dao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);

  }

}