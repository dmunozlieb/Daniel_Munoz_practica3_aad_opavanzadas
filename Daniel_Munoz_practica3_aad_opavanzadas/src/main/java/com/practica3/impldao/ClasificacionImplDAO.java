package com.practica3.impldao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.practica3.dao.ConsultaClasificacionDAO;
import com.practica3.liga.Fichajes;
import com.practica3.model.Clasificacion;
import com.practica3.model.Equipo;
import com.practica3.model.Patrocinador;
import com.practica3.service.HibernateUtil;

import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

/***
 * Esta clase realiza/se encarga de generar consultas relacionadas con la
 * clasificación. *
 * 
 * @author Daniel Muñoz
 */
public class ClasificacionImplDAO implements ConsultaClasificacionDAO {

	private static final Logger LOGGER = LogManager.getLogger(Fichajes.class);

	@Override
	public List<Clasificacion> getClasificacionFinal() {
		try (Session session = HibernateUtil.getSession().openSession()) {
			String queryOrder = "select c from Clasificacion c order by puntuacion desc";
			TypedQuery<Clasificacion> query = session.createQuery(queryOrder, Clasificacion.class);
			List<Clasificacion> clasif_order = query.getResultList();
			return clasif_order;
		} catch (IllegalStateException e) {
			LOGGER.error(e.getMessage());
		} catch (PersistenceException e) {
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;

	}

	@Override
	public List<Patrocinador> getPatrocinadoresFinanciera(int id_equipo) {
		try (Session session = HibernateUtil.getSession().openSession()) {
			String queryOrder = "select p from Equipo e join e.patrocinadores p where e.id_equipo = :idequipo order by p.montoPatrocinio desc";
			TypedQuery<Patrocinador> query = session.createQuery(queryOrder, Patrocinador.class);
			query.setParameter("idequipo", id_equipo);
			List<Patrocinador> patrocinadores_order = query.getResultList();
			return patrocinadores_order;
		} catch (IllegalStateException e) {
			LOGGER.error(e.getMessage());
		} catch (PersistenceException e) {
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Equipo getEquipoMaxIngresos() {
		try (Session session = HibernateUtil.getSession().openSession()) {
			String queryOrder = "select e from Equipo e order by renumeracion desc limit 1";
			TypedQuery<Equipo> query = session.createQuery(queryOrder, Equipo.class);
			Equipo equipo = query.getSingleResult();
			return equipo;
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
