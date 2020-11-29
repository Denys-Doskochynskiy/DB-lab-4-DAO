package org.lab.dao.lab_dao.model.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lab.dao.lab_dao.model.dao.GenericDAO;
import org.lab.dao.lab_dao.model.entity.PassengerTaxiInfo;
import org.lab.dao.lab_dao.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class PassengerTaxiInfoDAO implements GenericDAO<PassengerTaxiInfo> {

  protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  @Override
  public List<PassengerTaxiInfo> findAll() {
    List<PassengerTaxiInfo> passengerTaxiInfoList = new ArrayList<>();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      passengerTaxiInfoList = session.createQuery("from PassengerTaxiInfo").getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return passengerTaxiInfoList;
  }

  @Override
  public PassengerTaxiInfo findOne(Integer id) throws SQLException {
    PassengerTaxiInfo passengerTaxiInfo = null;

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      passengerTaxiInfo = session.get(PassengerTaxiInfo.class, id);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return passengerTaxiInfo;
  }

  @Override
  public void create(PassengerTaxiInfo passengerTaxiInfo) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.save(passengerTaxiInfo);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Integer id, PassengerTaxiInfo passengerTaxiInfo) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.update(passengerTaxiInfo);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      PassengerTaxiInfo passengerTaxiInfo = session.get(PassengerTaxiInfo.class, id);
      if (passengerTaxiInfo != null) {
        session.delete(passengerTaxiInfo);
      }
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}