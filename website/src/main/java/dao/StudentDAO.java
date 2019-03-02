package dao;


import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import entities.Student;
import persistence.HibernateUtil;


public class StudentDAO extends EntityDAO<Student> {

	private Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public List<Student> getAll() {
		try {
			session.beginTransaction();
			List<Student> students = session.createCriteria(Student.class).list();
			session.getTransaction().commit();

			return students;
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}

	@Override
	public Student get(long id) {
		try {
			session.beginTransaction();
			Student student = (Student) session.createCriteria(Student.class).add(Restrictions.idEq(id)).uniqueResult();
			session.getTransaction().commit();

			return student;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void insert(Student t) throws Exception {
		try {
			session.getTransaction().begin();
			session.save(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Student t) throws Exception {
		try {
			session.getTransaction().begin();
			session.update(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Student t) throws Exception {
		try {
			session.getTransaction().begin();
			session.delete(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}
	
}
