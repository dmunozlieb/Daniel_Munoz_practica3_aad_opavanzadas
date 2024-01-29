package com.practica3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Matchs")
public class Partido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_match")
	private Long id_partido;
	@Column(name = "matchdaynumber")
	private Integer num_jornada;
	@ManyToOne
	@JoinColumn(name = "local_team")
	private Equipo equipoLocal;
	@ManyToOne
	@JoinColumn(name = "away_team")
	private Equipo equipoVisitante;
	@Column(name = "local_goals")
	private Integer resultado_local;
	@Column(name = "away_goals")
	private Integer resultado_visitante;
	@ManyToOne
	@JoinColumn(name = "top_scorer")
	private Jugador jugador;

	public Partido() {

	}

	public Partido(Integer num_jornada,Equipo equipoLocal, Equipo equipoVisitante, Integer resultado_local, Integer resultado_visitante,
			Jugador jugador) {
		this.num_jornada = num_jornada;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.resultado_local = resultado_local;
		this.resultado_visitante = resultado_visitante;
		this.jugador = jugador;
	}

	public Long getId_partido() {
		return id_partido;
	}

	public void setId_partido(Long id_partido) {
		this.id_partido = id_partido;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public Integer getResultado_local() {
		return resultado_local;
	}

	public void setResultado_local(Integer resultado_local) {
		this.resultado_local = resultado_local;
	}

	public Integer getResultado_visitante() {
		return resultado_visitante;
	}

	public void setResultado_visitante(Integer resultado_visitante) {
		this.resultado_visitante = resultado_visitante;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public String toString() {
		return "Partido [id_partido=" + id_partido + ", equipoLocal=" + equipoLocal + ", equipoVisitante="
				+ equipoVisitante + ", resultado_local=" + resultado_local + ", resultado_visitante="
				+ resultado_visitante + ", jugador=" + jugador + "]";
	}

}
