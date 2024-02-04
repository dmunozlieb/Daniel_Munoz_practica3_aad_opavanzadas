package com.practica3.liga;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practica3.data.PremioRenumeracion;
import com.practica3.impldao.ClasificacionImplDAO;
import com.practica3.impldao.PartidoImplDAO;
import com.practica3.model.Clasificacion;
import com.practica3.model.Equipo;
import com.practica3.model.Partido;
import com.practica3.model.Patrocinador;

public class ConsultasCompeticion {
	private static ClasificacionImplDAO clasificacionDAO = new ClasificacionImplDAO();
	private static PartidoImplDAO partidoDAO = new PartidoImplDAO();

	private static final Logger LOGGER = LogManager.getLogger(Fichajes.class);

	public static void ejecutarConsultas() {
		ejecutarConsulta1();
		ejecutarConsulta3();
		ejecutarConsulta4();
		ejecutarConsulta5();
	}

	private static void ejecutarConsulta1() {
		LOGGER.info("## 1. Clasificacion final y renumeración obtenida ##");
		int posicion = 0;
		for (Clasificacion clasificacion : clasificacionDAO.getClasificacionFinal()) {
			LOGGER.info(++posicion + " " + clasificacion.toString());
			LOGGER.info("Renumeracion obtenida: " + PremioRenumeracion.valorPremio(posicion));
		}

		LOGGER.info("##################### FIN Consulta 1 #################################");
	}

	private static void ejecutarConsulta3() {
		LOGGER.info("## 3. Patrocinadores de un equipo según su magnitud financiera ##");
		int id_equipo = 1;
		LOGGER.info("Patrocinadores del equipo con el id: " + id_equipo);
		for (Patrocinador patrocinador : clasificacionDAO.getPatrocinadoresFinanciera(id_equipo)) {
			LOGGER.info(patrocinador.toString());
		}

		LOGGER.info("##################### FIN Consulta 3 #################################");
	}

	private static void ejecutarConsulta4() {
		LOGGER.info("## 4. Partido jornada 3 de un equipo ##");
		int id_equipo = 4;
		LOGGER.info("Partido del equipo con el id: " + id_equipo);
		Partido partido = partidoDAO.getResultadoJornada3(id_equipo);
		LOGGER.info(partido.toString());
		LOGGER.info("##################### FIN Consulta 4 #################################");
	}
	
	private static void ejecutarConsulta5() {
		LOGGER.info("## 5. Equipo con más ingresos y el total. ##");
		Equipo equipo = clasificacionDAO.getEquipoMaxIngresos();
		LOGGER.info("Equipo: "+equipo.getNombre_equipo()+" ingresos totales: "+equipo.getRenumeracion());
		LOGGER.info("##################### FIN Consulta 5 #################################");
	}
}
