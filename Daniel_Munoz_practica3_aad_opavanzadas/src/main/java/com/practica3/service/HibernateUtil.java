package com.practica3.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import jakarta.persistence.PersistenceException;

/***
 * Esta clase realiza/se encarga de devolver la conexión a la base de datos. *
 * 
 * @author Daniel Muñoz
 */

public class HibernateUtil {

	private static SessionFactory sessionfactory;

	static {
		try {
			StandardServiceRegistry standardservice = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(standardservice).getMetadataBuilder().build();

			sessionfactory = metadata.getSessionFactoryBuilder().build();
		} catch (PersistenceException persistence) {
			persistence.printStackTrace();
		}
	}

	public static SessionFactory getSession() {
		return sessionfactory;
	}
}
