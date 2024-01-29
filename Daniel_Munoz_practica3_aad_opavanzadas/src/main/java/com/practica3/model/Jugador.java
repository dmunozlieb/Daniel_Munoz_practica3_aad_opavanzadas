package com.practica3.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Player")
public class Jugador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_player")
	private Long id_jugador;
	@Column(name = "player_name", length = 30, nullable = false)
	private String nombre;
	@Column(name = "birth_date", nullable = false)
	private LocalDate fecha_nacimiento;
	@Column(name = "nationality", length = 25, nullable = false)
	private String nacionalidad;
	@Column(name = "position", length = 25, nullable = false)
	private String posicion;
	@Column(name = "height", nullable = false)
	private Integer altura;
	@Column(name = "weight", nullable = false)
	private Integer peso;
	@ManyToOne
	@JoinColumn(name = "id_team")
	private Equipo equipo;

	public Jugador() {

	}

	public Jugador(String nombre, LocalDate fecha_nacimiento, String nacionalidad, String posicion, Integer altura, Integer peso) {

		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.nacionalidad = nacionalidad;
		this.posicion = posicion;
		this.altura = altura;
		this.peso = peso;
	}

	

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Long getId_jugador() {
		return id_jugador;
	}

	public void setId_jugador(Long id_jugador) {
		this.id_jugador = id_jugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "\nJugador [id_jugador=" + id_jugador + ", nombre=" + nombre + ", fecha nacimiento=" + fecha_nacimiento + ", nacionalidad="
				+ nacionalidad + ", posicion=" + posicion + ", altura=" + altura + ", peso=" + peso + ", equipo="
				+ equipo + "]";
	}

}
