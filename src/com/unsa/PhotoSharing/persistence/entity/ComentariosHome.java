// default package
// Generated 03-jun-2014 9:20:39 by Hibernate Tools 3.4.0.CR1
package com.unsa.PhotoSharing.persistence.entity;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Comentarios.
 * @see .Comentarios
 * @author Hibernate Tools
 */
public class ComentariosHome {

	private static final Log log = LogFactory.getLog(ComentariosHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Comentarios transientInstance) {
		log.debug("persisting Comentarios instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Comentarios instance) {
		log.debug("attaching dirty Comentarios instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Comentarios instance) {
		log.debug("attaching clean Comentarios instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Comentarios persistentInstance) {
		log.debug("deleting Comentarios instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Comentarios merge(Comentarios detachedInstance) {
		log.debug("merging Comentarios instance");
		try {
			Comentarios result = (Comentarios) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Comentarios findById(java.lang.Integer id) {
		log.debug("getting Comentarios instance with id: " + id);
		try {
			Comentarios instance = (Comentarios) sessionFactory
					.getCurrentSession().get("Comentarios", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Comentarios> findByExample(Comentarios instance) {
		log.debug("finding Comentarios instance by example");
		try {
			List<Comentarios> results = (List<Comentarios>) sessionFactory
					.getCurrentSession().createCriteria("Comentarios")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
