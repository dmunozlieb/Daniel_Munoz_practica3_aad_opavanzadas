package com.practica3.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practica3.data.GenerarSponsorsEquipo;
import com.practica3.data.PremioRenumeracion;
import com.practica3.impldao.ClasificacionImplDAO;
import com.practica3.model.Clasificacion;
import com.practica3.model.Equipo;
import com.practica3.model.Patrocinador;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class ClasificacionService<T> {

	private static GestionEntity<Object> gestion = new GestionEntity<Object>();
	private static ClasificacionImplDAO clasificacionDAO = new ClasificacionImplDAO();

	public static void aportar_renumeracion() {
		int posicion = 0;
		for (Clasificacion clasificacion : clasificacionDAO.getClasificacionFinal()) {
			System.out.println(clasificacion.getEquipo().getRenumeracion());
			almacenarRenumeracionClasificacion(clasificacion.getEquipo(), ++posicion);
			addPatrocinios(clasificacion.getEquipo(), posicion);
			addRenumeracionSponsors(clasificacion.getEquipo());
			actualizarEquipo(clasificacion.getEquipo());
			System.out.println(clasificacion.getEquipo().getRenumeracion());

		}
	}

	private static void almacenarRenumeracionClasificacion(Equipo equipo, int posicion) {
		double renumeracion_equipo = 0;
		renumeracion_equipo = equipo.getRenumeracion() + PremioRenumeracion.valorPremio(posicion);
		equipo.setRenumeracion(renumeracion_equipo);
	}

	private static void actualizarEquipo(Equipo equipo) {
		gestion.update(equipo);
	}

	private static void addPatrocinios(Equipo equipo, int posicion) {
		List<Patrocinador> patrocinadores = GenerarSponsorsEquipo.getSponsorByTeam(posicion);
		equipo.agregarSponsors(patrocinadores);
	}

	private static void addRenumeracionSponsors(Equipo equipo) {
		double renumeracion_equipo;
		for (Patrocinador patrocinador : equipo.getPatrocinadores()) {
			renumeracion_equipo = 0;
			renumeracion_equipo = equipo.getRenumeracion() + patrocinador.getMontoPatrocinio();
			equipo.setRenumeracion(renumeracion_equipo);
		}
	}
}
