package com.practica3.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "competition")
public class Competicion {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (name = "competition_name")
	private String nombreCompeticion;
	@Column (name = "start_date")
	private LocalDate fechaCreacion;
	@Column (name = "numbers_of_matchday")
	private int numJornadas;
	@Column (name = "numbers_of_teams")
	private int numEquipos;
	
		
	public Competicion() {
		
	}

	public Competicion(String nombreCompeticion, LocalDate fechaCreacion, int numJornadas,int numEquipos) {		
		this.nombreCompeticion = nombreCompeticion;
		this.fechaCreacion = fechaCreacion;
		this.numJornadas = numJornadas;
		this.numEquipos = numEquipos;	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCompeticion() {
		return nombreCompeticion;
	}

	public void setNombreCompeticion(String nombreCompeticion) {
		this.nombreCompeticion = nombreCompeticion;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getNumEquipos() {
		return numEquipos;
	}

	public void setNumEquipos(int numEquipos) {
		this.numEquipos = numEquipos;
	}

	@Override
	public String toString() {
		return "Competicion [id=" + id + ", nombreCompeticion=" + nombreCompeticion + ", fechaCreacion=" + fechaCreacion
				+ ", numEquipos=" + numEquipos + "]";
	}
	
	
}
