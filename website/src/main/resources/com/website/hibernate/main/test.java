package com.website.hibernate.main;

import org.hibernate.classic.Session;

public class test {

	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Student student = new Student();
		student.setFirstName("Phuong");
		student.setLastName("Mai");
		student.setAge(24);
		
		session.save(student);
		session.getTransaction().commit();
	}

}
