package com.practica3.dao;

import java.util.List;

import com.practica3.model.Equipo;
import com.practica3.model.Jugador;

public interface GestionDAO<T> {
	void insert(T o1);

	<T>void remove(T o1);

	<T> T find(Class<T> className, int id);

	<T>List<T> findAll(Class<T> className);
	
	<T>void update(T o1);
	

}
