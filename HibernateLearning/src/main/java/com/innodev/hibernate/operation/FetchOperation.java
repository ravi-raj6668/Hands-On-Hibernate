package com.innodev.hibernate.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.innodev.hibernate.entity.Address;
import com.innodev.hibernate.entity.Student;

public class FetchOperation {
	public static void main(String[] args) throws Exception {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Student student = (Student) session.get(Student.class, 1);
			System.out.println(student);
			System.out.println(student.getName());
			
			Student student1 = (Student) session.load(Student.class, 1);
			System.out.println(student1);
			System.out.println(student1.getName());

			Address address = (Address) session.load(Address.class, 1);
			System.out.println(address.getCity());

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}
}
