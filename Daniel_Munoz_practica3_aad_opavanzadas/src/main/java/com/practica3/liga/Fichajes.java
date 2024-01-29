package com.practica3.liga;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practica3.model.Equipo;
import com.practica3.model.Jugador;
import com.practica3.service.GestionEquipo;


public class Fichajes <T>{
	
	private static final Logger LOGGER = LogManager.getLogger(Fichajes.class);
	private GestionEquipo <T> gestion = new GestionEquipo<>();
	private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public void fichajesTemporada() {
		intercambioJugadores();
		fichajeBidasoa();
		ratiradaJugador();
		fichajeViveros();
	}
	
	private void intercambioJugadores() {
		LOGGER.info("** Intercambio de jugadores entre el Barcelona y el Granollers **");
		LOGGER.info("** BARCELONA: EI WANNE <-----> Guilherme Torriani EI y 10000 :GRANOLLERS**");
		Equipo barcelona = gestion.find(Equipo.class, 1);
		Equipo granollers = gestion.find(Equipo.class, 3);
		Jugador wanne = gestion.find(Jugador.class, 6);
		Jugador torriani = gestion.find(Jugador.class, 19);
		barcelona.eliminarJugador(wanne);
		granollers.eliminarJugador(torriani);
		barcelona.agregarJugador(torriani);
		granollers.agregarJugador(wanne);
		gestion.update(barcelona);
		gestion.update(granollers);
	}
	
	private void fichajeBidasoa() {
		LOGGER.info("** Fichaje del bidasoa de Ismael El Korchi del BM. LOGROÑO LA RIOJA **");
		LOGGER.info("** Ismael El Korchi -----> 100000 euros **");
		Equipo bidasoa = gestion.find(Equipo.class, 2);
		Equipo logronio = gestion.find(Equipo.class, 4);
		Jugador korchi = gestion.find(Jugador.class, 23);
		logronio.eliminarJugador(korchi);
		bidasoa.agregarJugador(korchi);
		bidasoa.setRenumeracion(restaSalarial(bidasoa, 100000));
		gestion.update(bidasoa);
		gestion.update(logronio);
	}
	
	private void ratiradaJugador() {
		LOGGER.info("** Isaías Guardiola - VIVEROS HEROL BM. NAVA ha tomado la decisión de retirarse del balonmano **");
		LOGGER.info("** Isaías Guardiola - LD ");
		Equipo viveros = gestion.find(Equipo.class, 8);
		Jugador isaias = gestion.find(Jugador.class, 52);
		viveros.eliminarJugador(isaias);
		gestion.remove(isaias);
		gestion.update(viveros);	
	}
	
	private void fichajeViveros() {
		LOGGER.info("** Fichaje del VIVEROS HEROL BM. NAVA, nuevo jugador incorporado **");
		LOGGER.info("** Alvaro Del Valle ---> 34000 **");
		Equipo viveros = gestion.find(Equipo.class, 8);
		viveros.agregarJugador(new Jugador("Alvaro Del Valle", LocalDate.parse("21/01/1994",PATTERN),"España","Lateral derecho",192,92));
		viveros.setRenumeracion(restaSalarial(viveros, 34000));
		gestion.update(viveros);
	}
	
	private double restaSalarial(Equipo equipo, double cantidad) {
		double salario = equipo.getRenumeracion();
		salario -= cantidad;
		return salario;
	}
}
