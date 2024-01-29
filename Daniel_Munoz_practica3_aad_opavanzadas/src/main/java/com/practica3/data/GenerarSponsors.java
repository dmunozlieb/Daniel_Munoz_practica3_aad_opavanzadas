package com.practica3.data;

import java.util.ArrayList;

import com.practica3.model.Patrocinador;

public class GenerarSponsors {
	
	private static ArrayList<Patrocinador> sponsors = new ArrayList<>();
	
	
	public static Patrocinador sponsorNike() {
		Patrocinador sponsorNike = new Patrocinador("Nike Sportswear","Indumentaria y Equipamiento",500000);
		sponsors.add(sponsorNike);
		return sponsorNike;		
	}
	
	public static Patrocinador sponsorPuma() {
		Patrocinador sponsorPuma = new Patrocinador("Puma Handball Performance","Indumentaria y Equipamiento",400000);
		sponsors.add(sponsorPuma);
		return sponsorPuma;		
	}
	
	public static Patrocinador sponsorLocal() {
		Patrocinador sponsorCafe = new Patrocinador("Café del Centro","Local",50000);
		sponsors.add(sponsorCafe);
		return sponsorCafe;		
	}
	
	public static Patrocinador sponsorHealth() {
		Patrocinador sponsorHealth = new Patrocinador("ProHealth Supplements","Nutrición",800000);
		sponsors.add(sponsorHealth);
		return sponsorHealth;		
	}
	
	public static Patrocinador sponsorAdidas() {
		Patrocinador sponsorAdidas = new Patrocinador("Adidas Handball Gear","Indumentaria y Equipamiento",450000);
		sponsors.add(sponsorAdidas);
		return sponsorAdidas;		
	}
	
	public static Patrocinador sponsorEnergy() {
		Patrocinador sponsorEnergy = new Patrocinador("PowerQuench Sports Drinks","Bebidas Energéticas",65000);
		sponsors.add(sponsorEnergy);
		return sponsorEnergy;		
	}
	
	public static Patrocinador sponsorSwift() {
		Patrocinador sponsorSwift = new Patrocinador("Swift Travel Services","Transporte",40000);
		sponsors.add(sponsorSwift);
		return sponsorSwift;		
	}
	
	public static Patrocinador sponsorMetro() {
		Patrocinador sponsorMetro = new Patrocinador("MetroMovers Transport","Transporte",45000);
		sponsors.add(sponsorMetro);
		return sponsorMetro;		
	}
	
	public static Patrocinador sponsorStar() {
		Patrocinador sponsorStar = new Patrocinador("Star Entertainment Group","Entretenimiento",200000);
		sponsors.add(sponsorStar);
		return sponsorStar;		
	}
	
	public static Patrocinador sponsorGameTime() {
		Patrocinador sponsorGameTime = new Patrocinador("GameTime Interactive","Entretenimiento",180000);
		sponsors.add(sponsorGameTime);
		return sponsorGameTime;		
	}
	
	public static Patrocinador sponsorVital() {
		Patrocinador sponsorVital = new Patrocinador("VitalCare Wellness Clinic","Salud",90000);
		sponsors.add(sponsorVital);
		return sponsorVital;		
	}
	
	public static Patrocinador sponsorConnect() {
		Patrocinador sponsorConnect = new Patrocinador("ConnectX Technologies","Tecnológico",100000);
		sponsors.add(sponsorConnect);
		return sponsorConnect;		
	}
	
	public static ArrayList<Patrocinador> allSponsors(){
		return sponsors;
	}
	
}
