package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import entities.Address;
import persistence.HibernateUtil;

public class AddressDAO extends EntityDAO<Address> {
	
	private Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public List<Address> getAll() {
		try {
			session.getTransaction().begin();
			Criteria criteria = session.createCriteria(Address.class);
			List<Address> addresses = criteria.list();
			session.getTransaction().commit();
			
			return addresses;
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}

	@Override
	public Address get(long id) {
		try {
			session.getTransaction().begin();
			Criteria criteria = session.createCriteria(Address.class);
			Address result = (Address)criteria.add(Restrictions.idEq(id));
			session.getTransaction().commit();
			
			return result;
		} catch (Exception e) {
			return null;
		}	
	}

	@Override
	public void insert(Address t) throws Exception{
		try {
			session.getTransaction().begin();
			session.save(t);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Address t) throws Exception{
		try {
			session.getTransaction().begin();
			session.save(t);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Address t) throws Exception {
		try {
			session.getTransaction().begin();
			session.delete(t);
			session.getTransaction().commit();			
		} catch (Exception e) {
			throw e;
		}
	}

}
