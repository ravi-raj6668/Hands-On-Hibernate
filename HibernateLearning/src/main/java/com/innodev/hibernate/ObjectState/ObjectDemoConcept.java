package com.innodev.hibernate.ObjectState;

import com.innodev.hibernate.entity.Certificate;
import com.innodev.hibernate.entity.Student;
import com.innodev.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.UUID;

public class ObjectDemoConcept {
    public static void main(String[] args) {
        // Hibernate Object States:
        // 1. Transient
        // 2. Persistent
        // 3. Detached
        // 4. Removed

        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

        //creating student object

        Student student = new Student();
        student.setName("Ravi");
        student.setCity("Bangalore");
        student.setCertificate(new Certificate(UUID.randomUUID(),"Java Hibernate Course", "1 months"));


        Student student1 = new Student();
        student1.setName("Saras");
        student1.setCity("Bangalore");
        student1.setCertificate(new Certificate(UUID.randomUUID(), "ASP.Net Core", "2.5 months"));
        //Transient state starts

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        session.save(student1);

        //student.setName("Java World");//persistent State
        transaction.commit();
        session.close();
        sessionFactory.close();


        student.setName("Welcome Code");//Detached State
        System.out.println(student);
    }
}
