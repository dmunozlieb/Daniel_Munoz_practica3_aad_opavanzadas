package com.practica3.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practica3.data.GenerarCompeticion;
import com.practica3.data.GenerarEquipos;
import com.practica3.model.Clasificacion;
import com.practica3.model.Competicion;
import com.practica3.model.Equipo;
import com.practica3.model.Partido;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public class DataPersist {

//	private static EntityManager entitymanager = ConnectJPA.getEntityManager();
	private static final Logger LOGGER = LogManager.getLogger(DataPersist.class);
	private static GestionEquipo<Object> gestion = new GestionEquipo<>();

	public void dataPersist() {
		try {
			persistEquipos();
			persistClasificacion();
			persistCompeticion();
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
		}
	}

	private void persistEquipos() throws PersistenceException {
		LOGGER.debug(" - - Entrada al método persitEquipos() - - ");
		for (Equipo equipo : GenerarEquipos.generarEquipos()) {
//			System.out.println(equipo);
			gestion.insert(equipo);

		}
	}

	private void persistClasificacion() throws PersistenceException {
		List<Equipo> equipos_registrados = gestion.findAll(Equipo.class);
		for (Equipo equipo : equipos_registrados) {
			gestion.insert(new Clasificacion(equipo, 0, 0, 0, 0));
		}
	}

	public void persistPartidos(List<Partido> partidos) {
		try {
			for (Partido partido : partidos) {
				gestion.insert(partido);
			}
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
		}

	}

	private void persistCompeticion() {
		try {
			for (Competicion competicion : GenerarCompeticion.generarCompeticiones()) {
				gestion.insert(competicion);
			}
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
		}
	}

	public void actualizarClasificacion(List<Clasificacion> nueva_clasificacion) {
		try {
			for (Clasificacion clasificacion : nueva_clasificacion) {
				gestion.update(clasificacion);
			}
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
		}
	}

}
