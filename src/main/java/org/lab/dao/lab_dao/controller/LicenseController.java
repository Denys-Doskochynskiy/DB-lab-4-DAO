package org.lab.dao.lab_dao.controller;


import org.lab.dao.lab_dao.model.dao.implementation.LicenseDAO;

import org.lab.dao.lab_dao.model.entity.License;

import java.sql.SQLException;
import java.util.List;

public class LicenseController implements GenericController<License> {

    LicenseDAO dao = new LicenseDAO();

    @Override
    public List<License> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public License findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(License entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, License entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}