package com.innodev.hql;

import com.innodev.hibernate.entity.Student;
import com.innodev.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPagination {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getConfiguration().buildSessionFactory();

        Session session = sessionFactory.openSession();

        Query<Student> query = session.createQuery("from Student", Student.class);

        //implementing pagination using hibernate

        query.setFirstResult(4);

        query.setMaxResults(10);

        List<Student> studentList = query.list();

        for(Student student : studentList){
            System.out.println(student.getId() + " : " + student.getName() + " : " + student.getCertificate().getCourse());
        }

        session.close();
        sessionFactory.close();
    }
}
