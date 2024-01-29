package com.practica3.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.practica3.model.Competicion;

public class GenerarCompeticion {
	private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	public static List<Competicion> generarCompeticiones(){
		return List.of(new Competicion("Liga Asobal", LocalDate.parse("10/09/2023", PATTERN), 5,6),
						new Competicion("Copa del rey balonmano",LocalDate.parse("10/10/2023", PATTERN), 6,24));
	}
}
