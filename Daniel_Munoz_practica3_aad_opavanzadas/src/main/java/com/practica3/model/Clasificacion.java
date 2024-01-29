package com.practica3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asobal_league")
public class Clasificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clasification")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_team")
	private Equipo equipo;
	@Column(name = "points", nullable = false, precision = 2)
	private Integer puntuacion;
	@Column(name = "W", nullable = false,  precision = 2)
	private Integer partidos_ganados;
	@Column(name = "E", nullable = false,  precision = 2)
	private Integer partidos_empatados;
	@Column(name = "D", nullable = false,  precision = 2)
	private Integer partidos_perdidos;

	public Clasificacion() {

	}

	public Clasificacion(Equipo equipo, Integer puntuacion, Integer partidos_ganados,
			Integer partidos_empatados, Integer partidos_perdidos) {

		
		this.equipo = equipo;
		this.puntuacion = puntuacion;
		this.partidos_ganados = partidos_ganados;
		this.partidos_empatados = partidos_empatados;
		this.partidos_perdidos = partidos_perdidos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Integer getPartidos_ganados() {
		return partidos_ganados;
	}

	public void setPartidos_ganados(Integer partidos_ganados) {
		this.partidos_ganados = partidos_ganados;
	}

	public Integer getPartidos_empatados() {
		return partidos_empatados;
	}

	public void setPartidos_empatados(Integer partidos_empatados) {
		this.partidos_empatados = partidos_empatados;
	}

	public Integer getPartidos_perdidos() {
		return partidos_perdidos;
	}

	public void setPartidos_perdidos(Integer partidos_perdidos) {
		this.partidos_perdidos = partidos_perdidos;
	}

	@Override
	public String toString() {
		return "Clasificacion [id=" + id + ", equipo=" + equipo + ", puntuacion="
				+ puntuacion + ", partidos_ganados=" + partidos_ganados + ", partidos_empatados=" + partidos_empatados
				+ ", partidos_perdidos=" + partidos_perdidos + "]";
	}

}
