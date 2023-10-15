package com.innodev.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.innodev.hibernate.entity.Address;
import com.innodev.hibernate.entity.Student;

public class App {
	public static void main(String[] args) throws IOException,FileNotFoundException {
		System.out.println("Project Started!");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		// creating student table
		Student student = new Student();
		student.setName("Python");
		student.setCity("PSF");
		System.out.println(student);

		// creating address table
		Address address = new Address();
		address.setStreet("Gangotri Layout");
		address.setCity("Bangalore");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(12.32);

		String filePath = "C:\\Users\\ravi7\\git\\hibernate\\HibernateLearning\\src\\main\\java\\bg_r_photo.png";
		FileInputStream fis = new FileInputStream(filePath);
		byte[] data = new byte[fis.available()];
		fis.read(data);
		address.setImage(data);
		System.out.println(address);
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(student);

		session.save(address);
		tx.commit();
		session.close();
		fis.close();
		System.out.println("Done");
	}
}
