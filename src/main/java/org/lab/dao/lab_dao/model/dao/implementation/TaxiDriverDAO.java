package org.lab.dao.lab_dao.model.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lab.dao.lab_dao.model.dao.GenericDAO;
import org.lab.dao.lab_dao.model.entity.TaxiDriver;
import org.lab.dao.lab_dao.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class TaxiDriverDAO implements GenericDAO<TaxiDriver> {

  protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  @Override
  public List<TaxiDriver> findAll() {
    List<TaxiDriver> taxiDriverList = new ArrayList<>();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      taxiDriverList = session.createQuery("from TaxiDriver").getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return taxiDriverList;
  }

  @Override
  public TaxiDriver findOne(Integer id) throws SQLException {
    TaxiDriver taxiDriver = null;

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      taxiDriver = session.get(TaxiDriver.class, id);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return taxiDriver;
  }

  @Override
  public void create(TaxiDriver taxiDriver) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.save(taxiDriver);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Integer id, TaxiDriver taxiDriver) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.update(taxiDriver);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      TaxiDriver taxiDriver = session.get(TaxiDriver.class, id);
      if (taxiDriver != null) {
        session.delete(taxiDriver);
      }
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}