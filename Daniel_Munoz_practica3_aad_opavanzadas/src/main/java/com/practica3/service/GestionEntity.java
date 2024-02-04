package com.practica3.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practica3.dao.GestionDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

/***
 * Esta clase realiza/se encarga de realizar operaciones CRUD de manera
 * genérica. *
 * 
 * @author Daniel Muñoz
 */

public class GestionEntity<T> implements GestionDAO<T> {

	private static final Logger LOGGER = LogManager.getLogger(GestionEntity.class);

	@Override
	public void insert(T o1) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSession().openSession();) {
			transaction = session.beginTransaction();
			session.persist(o1);
			transaction.commit();
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
			transaction.rollback();
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
			transaction.rollback();
		}
	}

	@Override
	public <T> void remove(T o1) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSession().openSession();) {
			transaction = session.beginTransaction();
			session.remove(o1);
			transaction.commit();
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
			transaction.rollback();
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
			transaction.rollback();
		}

	}

	@SuppressWarnings("hiding")
	@Override
	public <T> List<T> findAll(Class<T> className) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSession().openSession()) {
			transaction = session.beginTransaction();
			TypedQuery<T> query = session.createQuery("select a from " + className.getSimpleName() + " a", className);
			List<T> allData = query.getResultList();
			transaction.commit();
			return allData;
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
			transaction.rollback();
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
			transaction.rollback();
		}
		return null;
	}

	@Override
	public <T> T find(Class<T> className, int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSession().openSession()) {
			transaction = session.beginTransaction();
			T object = session.get(className, id);
			transaction.commit();
			return object;
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
			transaction.rollback();
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
			transaction.rollback();
		}
		return null;
	}

	@Override
	public <T> void update(T o1) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSession().openSession()) {
			transaction = session.beginTransaction();
			session.merge(o1);
			transaction.commit();
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
			persistence.printStackTrace();
			transaction.rollback();
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
		}

	}

}
