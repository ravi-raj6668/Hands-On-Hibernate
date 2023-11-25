package com.innodev.caching;

import com.innodev.hibernate.entity.Student;
import com.innodev.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FirstLevelCache {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getConfiguration().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Student student = session.get(Student.class, 1);
        System.out.println(student);


        System.out.println("-----------------------------");

        Student student1 = session.get(Student.class, 1);
        System.out.println(student1);

        System.out.println(session.contains(student1));
        session.close();
        sessionFactory.close();
    }
}
