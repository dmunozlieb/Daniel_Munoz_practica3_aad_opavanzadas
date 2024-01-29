package com.practica3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "sponsor")
public class Patrocinador {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_sponsor")
	private Long id_patrocinador;
	@Column (name = "sponsor_name")
	private String nombre_patrocinador;
	@Column (name = "sponsor_type")
	private String tipo_patrocinio;
	@Column (name = "sponsor_amount", scale = 3)
	private Double montoPatrocinio;
	
	public Patrocinador() {
		
	}

	public Patrocinador(String nombre_patrocinador, String tipo_patrocinio, double montoPatrocinio) {
		
		this.nombre_patrocinador = nombre_patrocinador;
		this.tipo_patrocinio = tipo_patrocinio;
		this.montoPatrocinio = montoPatrocinio;
	}

	public Long getId_patrocinador() {
		return id_patrocinador;
	}

	public void setId_patrocinador(Long id_patrocinador) {
		this.id_patrocinador = id_patrocinador;
	}

	public String getNombre_patrocinador() {
		return nombre_patrocinador;
	}

	public void setNombre_patrocinador(String nombre_patrocinador) {
		this.nombre_patrocinador = nombre_patrocinador;
	}

	public String getTipo_patrocinio() {
		return tipo_patrocinio;
	}

	public void setTipo_patrocinio(String tipo_patrocinio) {
		this.tipo_patrocinio = tipo_patrocinio;
	}

	public Double getMontoPatrocinio() {
		return montoPatrocinio;
	}

	public void setMontoPatrocinio(Double montoPatrocinio) {
		this.montoPatrocinio = montoPatrocinio;
	}

	@Override
	public String toString() {
		return "\nPatrocinador [id_patrocinador=" + id_patrocinador + ", nombre_patrocinador=" + nombre_patrocinador
				+ ", tipo_patrocinio=" + tipo_patrocinio + ", montoPatrocinio=" + montoPatrocinio + "]";
	}
	
	
}
