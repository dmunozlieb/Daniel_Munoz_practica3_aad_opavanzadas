package com.practica3.data;

import java.util.HashMap;
import java.util.List;

import com.practica3.model.Jugador;

public class GenerarJugadoresEquipo {
	private static HashMap<String, List<Jugador>>jugadoresPorEquipo = new HashMap<String, List<Jugador>>();
	
	static {
		jugadoresPorEquipo.put("BARÇA", GenerarJugadores.jugadoresBarsa());
		jugadoresPorEquipo.put("BIDASOA IRUN", GenerarJugadores.jugadoresBidasoa());
		jugadoresPorEquipo.put("FRAIKIN BM. GRANOLLERS", GenerarJugadores.jugadoresGranollers());
		jugadoresPorEquipo.put("BM. LOGROÑO LA RIOJA", GenerarJugadores.jugadoresRioja());
		jugadoresPorEquipo.put("RECOLETAS AT. VALLADOLID", GenerarJugadores.jugadoresValladolid());
		jugadoresPorEquipo.put("BATHCO BM. TORRELAVEGA", GenerarJugadores.jugadoresTorrelavega());
		jugadoresPorEquipo.put("HELVETIA ANAITASUNA", GenerarJugadores.jugadoresHelvetia());
		jugadoresPorEquipo.put("VIVEROS HEROL BM. NAVA", GenerarJugadores.jugadoresViveros());
	}
	
	public static List<Jugador> getJugadoresByTeam(String nombreEquipo){
		return jugadoresPorEquipo.get(nombreEquipo);
	}
}
