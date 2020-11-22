package org.lab.dao.lab_dao.controller;

import org.lab.dao.lab_dao.model.dao.implementation.TaxiPassengerDAO;

import org.lab.dao.lab_dao.model.entity.TaxiPassenger;

import java.sql.SQLException;
import java.util.List;

public class TaxiPassengerController implements GenericController<TaxiPassenger> {

    TaxiPassengerDAO dao = new TaxiPassengerDAO();

    @Override
    public List<TaxiPassenger> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public TaxiPassenger findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(TaxiPassenger entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, TaxiPassenger entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}