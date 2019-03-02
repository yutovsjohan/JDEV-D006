package dao;

import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import entities.Course;
import persistence.HibernateUtil;


public class CourseDAO extends EntityDAO<Course>{

	private Session session = HibernateUtil.getSessionFactory().openSession();
	
	@Override
	public List<Course> getAll() {
		try {
			session.beginTransaction();
			List<Course> courses = session.createCriteria(Course.class).list();
			session.getTransaction().commit();

			return courses;
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}

	@Override
	public Course get(long id) {
		try {
			session.beginTransaction();
			Course course = (Course) session.createCriteria(Course.class).add(Restrictions.idEq(id)).uniqueResult();
			session.getTransaction().commit();

			return course;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void insert(Course t) throws Exception {
		try {
			session.getTransaction().begin();
			session.save(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Course t) throws Exception {
		try {
			session.getTransaction().begin();
			session.update(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Course t) throws Exception {
		try {
			session.getTransaction().begin();
			session.delete(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}
}
