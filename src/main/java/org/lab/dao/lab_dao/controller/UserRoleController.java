package org.lab.dao.lab_dao.controller;

import org.lab.dao.lab_dao.model.dao.implementation.UserRoleDAO;
import org.lab.dao.lab_dao.model.entity.UserRole;

import java.sql.SQLException;
import java.util.List;

public class UserRoleController implements GenericController<UserRole> {

    UserRoleDAO dao = new UserRoleDAO();

    @Override
    public List<UserRole> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public UserRole findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(UserRole entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, UserRole entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}