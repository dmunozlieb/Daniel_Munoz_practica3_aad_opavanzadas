package com.practica3.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

/***
 * Entity Equipo *
 * 
 * @author Daniel Muñoz
 */
@Entity
@Table(name = "Team")
public class Equipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_team")
	private Long id_equipo;
	@Column(name = "team_name", length = 30, nullable = false)
	private String nombre_equipo;
	@Column(name = "balance", nullable = true, scale = 3)
	private double renumeracion;
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "id_stadium")
	private Estadio estadio;

	@OneToMany(mappedBy = "equipo", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.EAGER)
	private List<Jugador> jugadores = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "Team_Sponsor", joinColumns = @JoinColumn(name = "id_team"), inverseJoinColumns = @JoinColumn(name = "id_sponsor"))
	private List<Patrocinador> patrocinadores = new ArrayList<>();

	public Equipo() {

	}

	public Equipo(String nombre_equipo, double renumeracion) {

		this.nombre_equipo = nombre_equipo;
		this.renumeracion = renumeracion;
	}

	public Equipo(String nombre_equipo, double renumeracion, Estadio estadio) {
		this(nombre_equipo, renumeracion);
		this.estadio = estadio;

	}

	public double getRenumeracion() {
		return renumeracion;
	}

	public void setRenumeracion(double renumeracion) {
		this.renumeracion = renumeracion;
	}

	public Long getId_equipo() {
		return id_equipo;
	}

	public void setId_equipo(Long id_equipo) {
		this.id_equipo = id_equipo;
	}

	public String getNombre_equipo() {
		return nombre_equipo;
	}

	public void setNombre_equipo(String nombre_equipo) {
		this.nombre_equipo = nombre_equipo;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public List<Patrocinador> getPatrocinadores() {
		return patrocinadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
		jugador.setEquipo(this);
	}

	public void agregarSponsor(Patrocinador patrocinador) {
		patrocinadores.add(patrocinador);
	}

	public void agregarSponsors(List<Patrocinador> patrocinador) {
		for (Patrocinador sponsor : patrocinador) {
			agregarSponsor(sponsor);
		}
	}

	public void eliminarSponsor(Patrocinador patrocinador) {
		patrocinadores.remove(patrocinador);
	}

	public void agregarJugadores(List<Jugador> list) {
		for (Jugador jugador : list) {
			agregarJugador(jugador);
		}
	}

	public void mostrarJugadores() {
		for (Jugador jugador : this.jugadores) {
			System.out.println(jugador.toString());
		}
	}

	public void eliminarJugador(Jugador jugador) {
		jugadores.remove(jugador);
		jugador.setEquipo(null);
	}

	@Override
	public String toString() {
		return "Equipo [id_equipo=" + id_equipo + ", nombre_equipo=" + nombre_equipo + ", renumeracion=" + renumeracion
				+ ", estadio=" + estadio + "]";
	}

}
