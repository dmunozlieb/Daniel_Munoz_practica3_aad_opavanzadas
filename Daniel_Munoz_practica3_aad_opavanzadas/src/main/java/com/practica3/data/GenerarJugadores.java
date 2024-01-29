package com.practica3.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import com.practica3.model.Jugador;

public class GenerarJugadores {

	private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static ArrayList<Jugador> jugadores = new ArrayList<>();
	public static List<Jugador> jugadoresBarsa() {
		return List.of(
				new Jugador("Pérez de Vargas", LocalDate.parse("10/01/1991", PATTERN), "España", "Portero", 188, 88),
				new Jugador("Carlsbogard", LocalDate.parse("19/04/1995", PATTERN), "Suecia", "Lateral izquierdo", 195,
						96),
				new Jugador("Mem", LocalDate.parse("31/08/1997", PATTERN), "Francia", "Lateral derecho", 194, 104),
				new Jugador("Valera", LocalDate.parse("19/08/1998", PATTERN), "España", "Central", 186, 86),
				new Jugador("Aleix", LocalDate.parse("07/05/1997", PATTERN), "España", "Extremo derecho", 183, 81),
				new Jugador("Wanne", LocalDate.parse("10/12/1993", PATTERN), "Suecia", "Extremo izquierdo", 185, 84),
				new Jugador("Gallego", LocalDate.parse("10/12/2001", PATTERN), "España", "Pívot", 199, 107));
	}

	public static List<Jugador> jugadoresBidasoa() {
		return List.of(
				new Jugador("Mehdi Harbaoui", LocalDate.parse("11/09/1996", PATTERN), "República Tunecina", "Portero",
						196, 95),
				new Jugador("Eneko Furundarena", LocalDate.parse("30/04/2003", PATTERN), "España", "Lateral izquierdo",
						194, 93),
				new Jugador("Rodrigo Salinas", LocalDate.parse("25/02/1989", PATTERN), "Chile", "Lateral derecho", 189,
						89),
				new Jugador("Asier Iribar", LocalDate.parse("02/04/2003", PATTERN), "España", "Central", 191, 90),
				new Jugador("Iñaki Cavero", LocalDate.parse("07/04/1996", PATTERN), "España", "Extremo derecho", 181,
						80),
				new Jugador("Mikel Zabala", LocalDate.parse("23/04/1998", PATTERN), "España", "Extremo izquierdo", 180,
						82),
				new Jugador("Marko Jevtic", LocalDate.parse("17/10/2001", PATTERN), "Serbia", "Pívot", 194, 103));
	}

	public static List<Jugador> jugadoresGranollers() {
		return List.of(
				new Jugador("Roberto Rodriguez", LocalDate.parse("19/07/2000", PATTERN), "España", "Portero", 187, 88),
				new Jugador("Joan Amigó", LocalDate.parse("17/07/1993", PATTERN), "España", "Lateral izquierdo", 190,
						90),
				new Jugador("Faruk Yusuf", LocalDate.parse("19/02/2004", PATTERN), "Nigeria", "Lateral derecho", 185,
						84),
				new Jugador("Sergi Franco", LocalDate.parse("10/05/1999", PATTERN), "España", "Extremo derecho", 190,
						89),
				new Jugador("Guilherme Torriani", LocalDate.parse("06/02/1999", PATTERN), "Brasil", "Extremo izquierdo",
						186, 85),
				new Jugador("Bruno Reguart", LocalDate.parse("25/05/2003", PATTERN), "España", "Central", 187, 84),
				new Jugador("Victor Romero", LocalDate.parse("09/03/2004", PATTERN), "España", "Pívot", 192, 101));
	}

	public static List<Jugador> jugadoresRioja() {
		return List.of(
				new Jugador("Kristóf Palasics", LocalDate.parse("19/04/2002", PATTERN), "Hungria", "Portero", 199, 105),
				new Jugador("Ismael El Korchi", LocalDate.parse("19/03/2001", PATTERN), "España", "Lateral izquierdo",
						194, 95),
				new Jugador("Angel Rivero", LocalDate.parse("24/10/1992", PATTERN), "Cuba", "Lateral derecho", 187, 95),
				new Jugador("Alvaro Preciado", LocalDate.parse("15/02/2000", PATTERN), "España", "Central", 188, 87),
				new Jugador("Edu Ortíz Badillo", LocalDate.parse("12/12/2002", PATTERN), "España", "Extremo derecho",
						184, 83),
				new Jugador("Marti Soler", LocalDate.parse("28/04/2003", PATTERN), "España", "Extremo izquierdo", 190,
						89),
				new Jugador("Abdoula Modi", LocalDate.parse("14/08/2001", PATTERN), "Togo", "Pívot", 211, 111));
	}

	public static List<Jugador> jugadoresValladolid() {
		return List.of(new Jugador("Cesar Pérez", LocalDate.parse("26/01/1993", PATTERN), "España", "Portero", 188, 88),
				new Jugador("Edu Calle", LocalDate.parse("03/05/2000", PATTERN), "España", "Lateral izquierdo", 185,
						84),
				new Jugador("Miguel Martínez Lobato", LocalDate.parse("31/12/1999", PATTERN), "España",
						"Lateral derecho", 195, 107),
				new Jugador("Tarcisio Freitas", LocalDate.parse("25/01/2000", PATTERN), "Brasil", "Central", 190, 90),
				new Jugador("Nicoló D´Antino", LocalDate.parse("22/06/1999", PATTERN), "Italia", "Extremo derecho", 170,
						74),
				new Jugador("Dimitar Dimitrioski", LocalDate.parse("16/02/1998", PATTERN), "Macedonia",
						"Extremo izquierdo", 183, 81),
				new Jugador("Álvaro Martínez Lobato", LocalDate.parse("31/12/1999", PATTERN), "España", "Pívot", 195,
						102));
	}

	public static List<Jugador> jugadoresTorrelavega() {
		return List.of(new Jugador("Carlos Calle", LocalDate.parse("22/12/1994", PATTERN), "España", "Portero", 192, 91),
				new Jugador("Sergio Crespo", LocalDate.parse("23/08/1996", PATTERN), "España", "Lateral izquierdo", 190,
						93),
				new Jugador("Alonso Moreno", LocalDate.parse("01/01/1996", PATTERN), "España", "Lateral derecho", 189,
						88),
				new Jugador("Adrián Fernández", LocalDate.parse("15/06/1994", PATTERN), "España", "Central", 188, 89),
				new Jugador("Javi Muñoz", LocalDate.parse("22/05/1992", PATTERN), "España", "Extremo derecho", 191, 93),
				new Jugador("Alex Rubiño", LocalDate.parse("06/11/2001", PATTERN), "España", "Extremo izquierdo", 181,
						78),
				new Jugador("Dani Ramos", LocalDate.parse("08/11/1999", PATTERN), "España", "Pívot", 191, 104));
	}
	
	public static List<Jugador> jugadoresHelvetia() {
		return List.of(new Jugador("Iñaki Martínez", LocalDate.parse("13/10/2000", PATTERN), "España", "Portero", 182, 84),
				new Jugador("Oleg Kisselev", LocalDate.parse("20/08/1997", PATTERN), "España", "Lateral izquierdo", 199,
						100),
				new Jugador("Eduardo Fernandez", LocalDate.parse("01/01/1997", PATTERN), "España", "Lateral derecho", 189,
						86),
				new Jugador("Niko Martinovic", LocalDate.parse("01/08/2003", PATTERN), "Croacia", "Central", 184, 83),
				new Jugador("Xavier Gonzalez", LocalDate.parse("10/12/2004", PATTERN), "España", "Extremo derecho", 180, 79),
				new Jugador("Martín Ganuza", LocalDate.parse("03/10/2000", PATTERN), "España", "Extremo izquierdo", 178,
						76),
				new Jugador("Antonio Bazan", LocalDate.parse("19/05/1996", PATTERN), "España", "Pívot", 196, 95));
	}
	
	public static List<Jugador> jugadoresViveros() {
		return List.of(new Jugador("Luis De Vega", LocalDate.parse("14/09/1988", PATTERN), "España", "Portero", 190, 89),
				new Jugador("Jakub Prokop", LocalDate.parse("21/08/1998", PATTERN), "Eslovaquia", "Lateral izquierdo", 191,
						97),
				new Jugador("Isaías Guardiola", LocalDate.parse("01/10/1984", PATTERN), "España", "Lateral derecho", 200,
						104),
				new Jugador("Borja Mendez", LocalDate.parse("19/07/2001", PATTERN), "España", "Central", 174, 78),
				new Jugador("Francisco Ahumada", LocalDate.parse("10/12/2004", PATTERN), "Chile", "Extremo derecho", 180, 79),
				new Jugador("Dani Perez", LocalDate.parse("20/12/1996", PATTERN), "España", "Extremo izquierdo", 182,
						80),
				new Jugador("Gonzalo Carró", LocalDate.parse("09/06/1994", PATTERN), "España", "Pívot", 194, 93));
	}
	
	public static ArrayList<Jugador> allJugadores(){
		jugadores.addAll(jugadoresBarsa());
		jugadores.addAll(jugadoresBidasoa());
		jugadores.addAll(jugadoresGranollers());
		jugadores.addAll(jugadoresRioja());
		jugadores.addAll(jugadoresTorrelavega());
		jugadores.addAll(jugadoresValladolid());
		return jugadores;
	}
}
