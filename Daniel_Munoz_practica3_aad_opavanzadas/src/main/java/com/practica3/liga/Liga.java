package com.practica3.liga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practica3.model.Clasificacion;
import com.practica3.model.Equipo;
import com.practica3.model.Partido;
import com.practica3.service.DataPersist;
import com.practica3.service.GestionEntity;

public class Liga {

	private static final Logger LOGGER = LogManager.getLogger(Liga.class);
	private static ArrayList<Partido> partidos_liga = new ArrayList<>();
	private static List<Clasificacion> clasificacion = new ArrayList<>();
	private static StringBuilder sb;
	private static DataPersist persistencia;
	private static GestionEntity<Object> gestion;

	public static void ejecutarLiga() {
		inicializarGestionYPersistencia();
		clasificacion = gestion.findAll(Clasificacion.class);
		LOGGER.info(" * * * * LIGA ASOBAL * * * * ");
		LOGGER.info(" --------------------------- ");
		int total_jornadas = clasificacion.size() - 1;
		int mitadEquipo = clasificacion.size() / 2;
		realizarJornada(total_jornadas,  mitadEquipo);
		persistencia.persistPartidos(partidos_liga);
		persistencia.actualizarClasificacion(clasificacion);	
		traspasos();
	}
	
	private static void inicializarGestionYPersistencia() {
	    gestion = new GestionEntity<>();
	    persistencia = new DataPersist();
	    persistencia.dataPersist();
	}
	
	private static void realizarJornada(int total_jornadas, int mitadEquipo) {
		for (int jornada = 0; jornada < total_jornadas; jornada++) {
			sb = new StringBuilder();
			LOGGER.info(" - - - Jornada " + (jornada + 1) + " - - - ");
			bucle2: for (int i = 0; i < mitadEquipo; i++) {
				LOGGER.info(" - - - Partido - - - ");
				Equipo equipo_local = clasificacion.get(i).getEquipo();
				Equipo equipo_visitante = clasificacion.get(clasificacion.size() - 1 - i).getEquipo();
				LOGGER.info(equipo_local.getNombre_equipo() + " - " + equipo_visitante.getNombre_equipo());
				int goles_locales = generarGoles();
				int goles_visitantes = generarGoles();
				sb.append("\n" + equipo_local.getNombre_equipo() + " " + goles_locales + " - " + goles_visitantes + " "
						+ equipo_visitante.getNombre_equipo());

				if (ganaLocal(goles_locales, goles_visitantes)) {
					victoria(i, clasificacion.size() - 1 - i);
					partidos_liga.add(generarPartido((jornada + 1), equipo_local, equipo_visitante, goles_locales,
							goles_visitantes));
					continue bucle2;
				}
				if (ganaVisitante(goles_locales, goles_visitantes)) {
					victoria(clasificacion.size() - 1 - i, i);
					partidos_liga.add(generarPartido((jornada + 1), equipo_local, equipo_visitante, goles_locales,
							goles_visitantes));
					continue bucle2;
				}
				empate(i, clasificacion.size() - 1 - i);
				partidos_liga.add(
						generarPartido((jornada + 1), equipo_local, equipo_visitante, goles_locales, goles_visitantes));

			}
			mostrarResultados();
			//Rotación de partidos
			Collections.rotate(clasificacion.subList(1, clasificacion.size()), 1);

		}
	}
	
	private static void mostrarResultados() {
	    LOGGER.info(" - - - Resultados - - - ");
	    LOGGER.info(" |____________________| ");
	    LOGGER.info(sb.toString());
	}

	private static boolean ganaLocal(int goles_local, int goles_visitante) {
		return goles_local > goles_visitante;
	}

	private static boolean ganaVisitante(int goles_local, int goles_visitante) {
		return goles_local < goles_visitante;
	}

	private static int generarGoles() {
		return (int) (Math.random() * 6);
	}

	
	private static void empate(int posicion_equipolocal, int posicion_equipovisitante) {
		int empate_total_local = clasificacion.get(posicion_equipolocal).getPartidos_empatados();
		int empate_total_visitante = clasificacion.get(posicion_equipovisitante).getPartidos_empatados();
		int puntuacion_total_local = clasificacion.get(posicion_equipolocal).getPuntuacion();
		int puntuacion_total_visitante = clasificacion.get(posicion_equipovisitante).getPuntuacion();
		
		empate_total_local += 1;
		empate_total_visitante += 1;
		puntuacion_total_local += 1;
		puntuacion_total_visitante += 1;
		
		clasificacion.get(posicion_equipolocal).setPartidos_empatados(empate_total_local);
		clasificacion.get(posicion_equipolocal).setPuntuacion(puntuacion_total_local);
		clasificacion.get(posicion_equipovisitante).setPartidos_empatados(empate_total_visitante);
		clasificacion.get(posicion_equipovisitante).setPuntuacion(puntuacion_total_visitante);
	}
	
	private static void victoria(int posicion_ganador, int posicion_perdedor) {
		int victorias_totales = clasificacion.get(posicion_ganador).getPartidos_ganados();
		int derrotas_totales = clasificacion.get(posicion_perdedor).getPartidos_perdidos();
		int puntuacion_total_ganador = clasificacion.get(posicion_ganador).getPuntuacion();
		
		victorias_totales += 1;
		derrotas_totales += 1;
		puntuacion_total_ganador += 3;
		
		clasificacion.get(posicion_ganador).setPuntuacion(puntuacion_total_ganador);
		clasificacion.get(posicion_ganador).setPartidos_ganados(victorias_totales);
		clasificacion.get(posicion_perdedor).setPartidos_perdidos(derrotas_totales);
	}

	private static Partido generarPartido(int num_jornada, Equipo equipo_local, Equipo equipo_visitante,
			int resultado_local, int resultado_visitante) {
		return new Partido(num_jornada, equipo_local, equipo_visitante, resultado_local, resultado_visitante, null);
	}


	private static <T> void traspasos() {
		Fichajes<T> fichajes = new Fichajes<>();
		fichajes.fichajesTemporada();
	}
	
	
}
