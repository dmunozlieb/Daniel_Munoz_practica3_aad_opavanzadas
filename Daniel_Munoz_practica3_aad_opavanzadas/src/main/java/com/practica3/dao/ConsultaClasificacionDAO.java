package com.practica3.dao;

import java.util.List;

import com.practica3.model.Clasificacion;
import com.practica3.model.Equipo;
import com.practica3.model.Patrocinador;

public interface ConsultaClasificacionDAO {
	List<Clasificacion> getClasificacionFinal();

	List<Patrocinador> getPatrocinadoresFinanciera(int id_equipo);

	Equipo getEquipoMaxIngresos();
}
