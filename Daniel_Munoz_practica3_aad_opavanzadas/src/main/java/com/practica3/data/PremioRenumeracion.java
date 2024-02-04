package com.practica3.data;

import java.util.HashMap;
import java.util.Map;

public class PremioRenumeracion {
	
	private static Map<Integer, Integer> premios_renumeracion = new HashMap<>();
	
	static {
		premios_renumeracion.put(1, 100000);
		premios_renumeracion.put(2, 90000);
		premios_renumeracion.put(3, 80000);
		premios_renumeracion.put(4, 70000);
		premios_renumeracion.put(5, 60000);
		premios_renumeracion.put(6, 50000);
		premios_renumeracion.put(7, 40000);
		premios_renumeracion.put(8, 30000);
	}
	
	public static Integer valorPremio(Integer posicion) {
		return premios_renumeracion.get(posicion);
	}
}
