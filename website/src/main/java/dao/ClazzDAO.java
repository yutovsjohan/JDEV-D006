package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import entities.Clazz;
import persistence.HibernateUtil;


public class ClazzDAO extends EntityDAO<Clazz>{

	private Session session = HibernateUtil.getSessionFactory().openSession();
	
	@Override
	public List<Clazz> getAll() {
		try {
			session.beginTransaction();
			List<Clazz> clazzes = session.createCriteria(Clazz.class).list();
			session.getTransaction().commit();

			return clazzes;
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}

	@Override
	public Clazz get(long id) {
		try {
			session.beginTransaction();
			Clazz clazz = (Clazz) session.createCriteria(Clazz.class).add(Restrictions.idEq(id)).uniqueResult();
			session.getTransaction().commit();

			return clazz;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void insert(Clazz t) throws Exception {
		try {
			session.getTransaction().begin();
			session.save(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Clazz t) throws Exception {
		try {
			session.getTransaction().begin();
			session.update(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Clazz t) throws Exception {
		try {
			session.getTransaction().begin();
			session.delete(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}
}
