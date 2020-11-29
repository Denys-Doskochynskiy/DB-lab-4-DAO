package org.lab.dao.lab_dao.model.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lab.dao.lab_dao.model.dao.GenericDAO;
import org.lab.dao.lab_dao.model.entity.License;
import org.lab.dao.lab_dao.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class LicenseDAO implements GenericDAO<License> {

  protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  @Override
  public List<License> findAll() {
    List<License> licenseList = new ArrayList<>();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      licenseList = session.createQuery("from License").getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return licenseList;
  }

  @Override
  public License findOne(Integer id) throws SQLException {
    License license = null;

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      license = session.get(License.class, id);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return license;
  }

  @Override
  public void create(License license) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.save(license);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Integer id, License license) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.update(license);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      License license = session.get(License.class, id);
      if (license != null) {
        session.delete(license);
      }
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}