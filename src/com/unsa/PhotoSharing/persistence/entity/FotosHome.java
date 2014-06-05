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
 * Home object for domain model class Fotos.
 * @see .Fotos
 * @author Hibernate Tools
 */
public class FotosHome {

	private static final Log log = LogFactory.getLog(FotosHome.class);

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

	public void persist(Fotos transientInstance) {
		log.debug("persisting Fotos instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Fotos instance) {
		log.debug("attaching dirty Fotos instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Fotos instance) {
		log.debug("attaching clean Fotos instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Fotos persistentInstance) {
		log.debug("deleting Fotos instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Fotos merge(Fotos detachedInstance) {
		log.debug("merging Fotos instance");
		try {
			Fotos result = (Fotos) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Fotos findById(java.lang.Integer id) {
		log.debug("getting Fotos instance with id: " + id);
		try {
			Fotos instance = (Fotos) sessionFactory.getCurrentSession().get(
					"Fotos", id);
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

	public List<Fotos> findByExample(Fotos instance) {
		log.debug("finding Fotos instance by example");
		try {
			List<Fotos> results = (List<Fotos>) sessionFactory
					.getCurrentSession().createCriteria("Fotos")
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
