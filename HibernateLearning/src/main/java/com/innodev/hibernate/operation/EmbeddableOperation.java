package com.innodev.hibernate.operation;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.innodev.hibernate.entity.Certificate;
import com.innodev.hibernate.entity.Student;

public class EmbeddableOperation {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("src/main/java/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Student student1 = new Student();
		student1.setName("Java_Developer");
		student1.setCity("Oracle_Corp");

		Certificate certificate1 = new Certificate();
		certificate1.setCertificateId(UUID.randomUUID());
		certificate1.setCourse("Android_Development");
		certificate1.setDuration("3months");
		student1.setCertificate(certificate1);

		Student student2 = new Student();
		student2.setName("Python_Developer");
		student2.setCity("PSE_Corp");

		Certificate certificate2 = new Certificate();
		certificate2.setCertificateId(UUID.randomUUID());
		certificate2.setCourse("IOS_Development");
		certificate2.setDuration("3.5months");
		student2.setCertificate(certificate2);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// saving the data in db
		session.save(student1);
		session.save(student2);

		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
