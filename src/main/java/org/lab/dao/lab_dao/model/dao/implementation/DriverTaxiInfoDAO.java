package org.lab.dao.lab_dao.model.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lab.dao.lab_dao.model.dao.GenericDAO;
import org.lab.dao.lab_dao.model.entity.DriverTaxiInfo;
import org.lab.dao.lab_dao.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class DriverTaxiInfoDAO implements GenericDAO<DriverTaxiInfo> {

  protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  @Override
  public List<DriverTaxiInfo> findAll() {
    List<DriverTaxiInfo> driverTaxiInfoList = new ArrayList<>();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      driverTaxiInfoList = session.createQuery("from DriverTaxiInfo").getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return driverTaxiInfoList;
  }

  @Override
  public DriverTaxiInfo findOne(Integer id) throws SQLException {
    DriverTaxiInfo driverTaxiInfo = null;

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      driverTaxiInfo = session.get(DriverTaxiInfo.class, id);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return driverTaxiInfo;
  }

  @Override
  public void create(DriverTaxiInfo driverTaxiInfo) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.save(driverTaxiInfo);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Integer id, DriverTaxiInfo driverTaxiInfo) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.update(driverTaxiInfo);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      DriverTaxiInfo driverTaxiInfo = session.get(DriverTaxiInfo.class, id);
      if (driverTaxiInfo != null) {
        session.delete(driverTaxiInfo);
      }
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}