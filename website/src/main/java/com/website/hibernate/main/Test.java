package com.website.hibernate.main;

import org.hibernate.classic.Session;

import com.website.hibernate.entities.Address;
import com.website.hibernate.entities.Student;
import com.website.hibernate.persistence.HibernateUtil;


public class Test {

	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Address address = new Address();
		
		address.setStreet("Nguyen Thi Minh Khai");
		address.setDistrict("Quan 1");
		address.setCity("TPHCM");		
		
		
		Student student = new Student();
		student.setFirstName("Mai");
		student.setLastName("Phuong");
		student.setAge(24);	
		student.setAddress(address);
		session.save(student);
		

		
		session.getTransaction().commit();
	}

}
