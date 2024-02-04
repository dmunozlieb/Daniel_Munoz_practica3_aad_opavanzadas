package com.practica3.data;

import java.util.ArrayList;

import com.practica3.model.Patrocinador;

/***
 * Esta clase realiza/se encarga de Generar objetos patrocinadores. *
 * 
 * @author Daniel Muñoz
 */
public class GenerarSponsors {

	private static ArrayList<Patrocinador> sponsors = new ArrayList<>();

	public static Patrocinador sponsorNike() {

		return obtenerOCrearPatrocinador("Nike Sportswear", "Indumentaria y Equipamiento", 500000);
	}

	public static Patrocinador sponsorPuma() {

		return obtenerOCrearPatrocinador("Puma Handball Performance", "Indumentaria y Equipamiento", 400000);
	}

	public static Patrocinador sponsorLocal() {

		return obtenerOCrearPatrocinador("Café del Centro", "Local", 50000);
	}

	public static Patrocinador sponsorHealth() {

		return obtenerOCrearPatrocinador("ProHealth Supplements", "Nutrición", 800000);
	}

	public static Patrocinador sponsorAdidas() {

		return obtenerOCrearPatrocinador("Adidas Handball Gear", "Indumentaria y Equipamiento", 450000);
	}

	public static Patrocinador sponsorEnergy() {

		return obtenerOCrearPatrocinador("PowerQuench Sports Drinks", "Bebidas Energéticas", 65000);
	}

	public static Patrocinador sponsorSwift() {

		return obtenerOCrearPatrocinador("Swift Travel Services", "Transporte", 40000);
	}

	public static Patrocinador sponsorMetro() {

		return obtenerOCrearPatrocinador("MetroMovers Transport", "Transporte", 45000);
	}

	public static Patrocinador sponsorStar() {

		return obtenerOCrearPatrocinador("Star Entertainment Group", "Entretenimiento", 200000);
	}

	public static Patrocinador sponsorGameTime() {

		return obtenerOCrearPatrocinador("GameTime Interactive", "Entretenimiento", 180000);
	}

	public static Patrocinador sponsorVital() {

		return obtenerOCrearPatrocinador("VitalCare Wellness Clinic", "Salud", 90000);
	}

	public static Patrocinador sponsorConnect() {

		return obtenerOCrearPatrocinador("ConnectX Technologies", "Tecnológico", 100000);
	}

	private static Patrocinador obtenerOCrearPatrocinador(String nombre, String categoria, int monto) {
		for (Patrocinador existente : sponsors) {
			if (existente.getNombre_patrocinador().equals(nombre)) {
				return existente;
			}
		}

		Patrocinador nuevoPatrocinador = new Patrocinador(nombre, categoria, monto);
		sponsors.add(nuevoPatrocinador);
		return nuevoPatrocinador;
	}

	public static ArrayList<Patrocinador> allSponsors() {
		return sponsors;
	}

}
