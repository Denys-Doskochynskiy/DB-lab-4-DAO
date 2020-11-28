package org.lab.dao.lab_dao.controller;


import org.lab.dao.lab_dao.model.dao.implementation.PassengerTaxiInfoDAO;
import org.lab.dao.lab_dao.model.entity.PassengerTaxiInfo;

import java.sql.SQLException;
import java.util.List;

public class PassengerTaxiInfoController implements GenericController<PassengerTaxiInfo> {

  PassengerTaxiInfoDAO dao = new PassengerTaxiInfoDAO();

  @Override
  public List<PassengerTaxiInfo> findAll() throws SQLException {
    return dao.findAll();
  }

  @Override
  public PassengerTaxiInfo findOne(Integer id) throws SQLException {
    return dao.findOne(id);
  }

  @Override
  public void create(PassengerTaxiInfo entity) throws SQLException {
    dao.create(entity);
  }

  @Override
  public void update(Integer id, PassengerTaxiInfo entity) throws SQLException {
    dao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);

  }

}