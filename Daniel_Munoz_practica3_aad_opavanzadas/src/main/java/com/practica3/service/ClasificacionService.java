package com.practica3.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practica3.model.Clasificacion;
import com.practica3.model.Equipo;

import jakarta.persistence.Query;

public class ClasificacionService<T> {
	
	private static double renumeracion_repartir = 100000;
	private static GestionEntity<Object> gestion = new GestionEntity<Object>();
	
	public static void aportar_renumeracion() {
		for(Clasificacion clasificacion:getClasificacionOrdenada()) {
			almacenarRenumeracion(clasificacion.getEquipo());	
			actualizarEquipo(clasificacion.getEquipo());
		}
	}
	
	private static List<Clasificacion> getClasificacionOrdenada() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSession().openSession()){
			transaction = session.beginTransaction();
			String queryOrder = "select c from Clasificacion c order by puntuacion desc";
			Query query = session.createQuery(queryOrder, Clasificacion.class);	
			List<Clasificacion> clasif_order = query.getResultList();
			transaction.commit();
			return clasif_order;
		}catch (Exception e) {
			System.err.println("ERROR - "+e.getMessage());
			transaction.rollback();
		}
		return null;
	}

	public static double getRenumeracion_repartir() {
		return renumeracion_repartir;
	}

	public static void setRenumeracion_repartir(double renumeracion_repartir) {
		ClasificacionService.renumeracion_repartir = renumeracion_repartir;
	}
	
	private static void almacenarRenumeracion(Equipo equipo) {
		double renumeracion_equipo = 0;
		renumeracion_equipo = equipo.getRenumeracion()+getRenumeracion_repartir();
		System.out.println(renumeracion_equipo);
		equipo.setRenumeracion(renumeracion_equipo);
		setRenumeracion_repartir(getRenumeracion_repartir()-10000);
	}
	
	private static void actualizarEquipo(Equipo equipo) {
		gestion.update(equipo);
	}
}
