package com.practica3.data;

import java.util.HashMap;
import java.util.List;

import com.practica3.model.Patrocinador;
/*** Esta clase realiza/se encarga de relacionar sponsors a posición en clasificación. * 
 * @author Daniel Muñoz */

public class GenerarSponsorsEquipo {
	private static HashMap<Integer, List<Patrocinador>> sponsorsEquipo = new HashMap<Integer, List<Patrocinador>>();
	
	static {
		sponsorsEquipo.put(1, List.of(GenerarSponsors.sponsorHealth(),GenerarSponsors.sponsorVital()));
		sponsorsEquipo.put(2, List.of(GenerarSponsors.sponsorNike(), GenerarSponsors.sponsorConnect()));
		sponsorsEquipo.put(3, List.of(GenerarSponsors.sponsorPuma(),GenerarSponsors.sponsorLocal()));
		sponsorsEquipo.put(4, List.of(GenerarSponsors.sponsorAdidas()));
		sponsorsEquipo.put(5, List.of(GenerarSponsors.sponsorStar(),GenerarSponsors.sponsorMetro()));
		sponsorsEquipo.put(6, List.of(GenerarSponsors.sponsorGameTime(),GenerarSponsors.sponsorSwift()));
		sponsorsEquipo.put(7, List.of(GenerarSponsors.sponsorConnect()));
		sponsorsEquipo.put(8,List.of());
	}
	
	public static List<Patrocinador> getSponsorByTeam(Integer posicion_clasificacion){
		return sponsorsEquipo.get(posicion_clasificacion);
	}
}
