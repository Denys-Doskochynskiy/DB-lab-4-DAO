package org.lab.dao.lab_dao.controller;


import org.lab.dao.lab_dao.model.dao.implementation.AutoDAO;

import org.lab.dao.lab_dao.model.entity.Auto;

import java.sql.SQLException;
import java.util.List;

public class AutoController implements GenericController<Auto> {

    AutoDAO dao = new AutoDAO();

    @Override
    public List<Auto> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Auto findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(Auto entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Auto entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}