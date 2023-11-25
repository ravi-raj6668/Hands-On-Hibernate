package com.innodev.caching;


import com.innodev.hibernate.entity.Student;
import com.innodev.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SecondLevelCache {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getConfiguration().buildSessionFactory();

        // First level caching
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, 1);
        System.out.println(student);

        session.close();

        // second level caching
        Session session1 = sessionFactory.openSession();
        Student student1 = session1.get(Student.class, 1);
        System.out.println(student1);
        session1.close();

        sessionFactory.close();
    }
}
