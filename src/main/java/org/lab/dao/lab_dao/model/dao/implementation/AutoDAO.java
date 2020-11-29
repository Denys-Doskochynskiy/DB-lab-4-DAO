package org.lab.dao.lab_dao.model.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lab.dao.lab_dao.model.dao.GenericDAO;
import org.lab.dao.lab_dao.model.entity.Auto;
import org.lab.dao.lab_dao.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class AutoDAO implements GenericDAO<Auto> {

  protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  @Override
  public List<Auto> findAll() {
    List<Auto> auto = new ArrayList<>();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      auto = session.createQuery("from Auto").getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return auto;
  }

  @Override
  public Auto findOne(Integer id) throws SQLException {
    Auto auto = null;

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      auto = session.get(Auto.class, id);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return auto;
  }

  @Override
  public void create(Auto credential) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.save(credential);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Integer id, Auto auto) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.update(auto);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      Auto auto = session.get(Auto.class, id);
      if (auto != null) {
        session.delete(auto);
      }
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}