package org.lab.dao.lab_dao.model.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lab.dao.lab_dao.model.dao.GenericDAO;
import org.lab.dao.lab_dao.model.entity.TaxiPassenger;
import org.lab.dao.lab_dao.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class TaxiPassengerDAO implements GenericDAO<TaxiPassenger> {

  protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  @Override
  public List<TaxiPassenger> findAll() {
    List<TaxiPassenger> taxiPassengerList = new ArrayList<>();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      taxiPassengerList = session.createQuery("from TaxiPassenger").getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return taxiPassengerList;
  }

  @Override
  public TaxiPassenger findOne(Integer id) throws SQLException {
    TaxiPassenger taxiPassenger = null;

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      taxiPassenger = session.get(TaxiPassenger.class, id);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return taxiPassenger;
  }

  @Override
  public void create(TaxiPassenger taxiPassenger) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.save(taxiPassenger);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Integer id, TaxiPassenger taxiPassenger) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.update(taxiPassenger);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      TaxiPassenger taxiPassenger = session.get(TaxiPassenger.class, id);
      if (taxiPassenger != null) {
        session.delete(taxiPassenger);
      }
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}