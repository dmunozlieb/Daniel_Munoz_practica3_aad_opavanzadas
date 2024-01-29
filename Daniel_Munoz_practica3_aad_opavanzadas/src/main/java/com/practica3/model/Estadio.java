package com.practica3.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stadium")
public class Estadio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_stadium")
	private Long id_estadio;
	@Column(name = "stadium_name")
	private String nombre_estadio;
	@Column(name = "stadium_city")
	private String ciudad_estadio;
	@Column(name = "opening_date")
	private LocalDate fecha_inauguracion;
	
	public Estadio() {
		
	}

	public Estadio(String nombre_estadio, String ciudad_estadio, LocalDate fecha_inauguracion) {

		this.nombre_estadio = nombre_estadio;
		this.ciudad_estadio = ciudad_estadio;
		this.fecha_inauguracion = fecha_inauguracion;
	}

	public Long getId_estadio() {
		return id_estadio;
	}

	public void setId_estadio(Long id_estadio) {
		this.id_estadio = id_estadio;
	}

	public String getNombre_estadio() {
		return nombre_estadio;
	}

	public void setNombre_estadio(String nombre_estadio) {
		this.nombre_estadio = nombre_estadio;
	}

	public String getCiudad_estadio() {
		return ciudad_estadio;
	}

	public void setCiudad_estadio(String ciudad_estadio) {
		this.ciudad_estadio = ciudad_estadio;
	}

	public LocalDate getFecha_inauguracion() {
		return fecha_inauguracion;
	}

	
	public void setFecha_inauguracion(LocalDate fecha_inauguracion) {
		this.fecha_inauguracion = fecha_inauguracion;
	}

	@Override
	public String toString() {
		return "Estadio [id_estadio=" + id_estadio + ", nombre_estadio=" + nombre_estadio + ", ciudad_estadio="
				+ ciudad_estadio + ", fecha_inauguracion=" + fecha_inauguracion + "]";
	}

}
