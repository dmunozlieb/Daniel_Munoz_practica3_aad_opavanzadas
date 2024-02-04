package com.practica3.impldao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.practica3.dao.ConsultaPartidoDAO;
import com.practica3.liga.Fichajes;
import com.practica3.model.Partido;
import com.practica3.service.HibernateUtil;

import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
/*** Esta clase realiza/se encarga de generar consultas relacionadas con los partidos. * 
 * @author Daniel Muñoz */
public class PartidoImplDAO implements ConsultaPartidoDAO {
	private static final Logger LOGGER = LogManager.getLogger(Fichajes.class);

	@Override
	public Partido getResultadoJornada3(int id_equipo) {
		try(Session session = HibernateUtil.getSession().openSession()) {
			String hql = "select p from Partido p join fetch p.equipoLocal el join fetch p.equipoVisitante ev " +
                    "where (el.id_equipo = :idequipo OR ev.id_equipo = :idequipo) and p.num_jornada = 3";
			TypedQuery<Partido> query = session.createQuery(hql,Partido.class);
			query.setParameter("idequipo", id_equipo);
			return query.getSingleResult();
		} catch (IllegalStateException e) {
			LOGGER.error(e.getMessage());
		} catch (PersistenceException e) {
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

}
