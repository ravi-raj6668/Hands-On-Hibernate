package com.innodev.hibernate.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.innodev.hibernate.entity.Student;

public class HibernateProgrammaticConfig {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(HibernateProgrammaticConfig.class);
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
            /* Configure Hibernate programmatically */
			Configuration config = new Configuration();
			config.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			config.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
			config.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/test_db");
			config.setProperty("hibernate.connection.username", "postgres");
			config.setProperty("hibernate.connection.password", "root");
			config.setProperty("hibernate.hbm2ddl.auto", "update");
			config.setProperty("hibernate.show_sql", "true");

			// Add annotated class (Student) programmatically
			config.addAnnotatedClass(Student.class);

			sessionFactory = config.buildSessionFactory();

			// Create a new student and save it
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			Student student = new Student();
			student.setName("Golang");
			student.setCity("GoggleCity");
			System.out.println(student);
			session.save(student);

			transaction.commit();

			// Retrieve a student by ID
			Student student1 = (Student) session.load(Student.class, 1);
			logger.info("Getting student data {} : ", student1);
			System.out.println("Getting student data : " + student1);
			System.out.println(student1);
			System.out.println("Retrieved Student: " + student1.getName());
		} catch (Exception e) {
			logger.info("Getting error while fetching and saving data to database : ", e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}

}
