package com.innodev.CriteriaAPI;

import com.innodev.hibernate.entity.Student;
import com.innodev.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CriteriaExample {
    public static void main(String[] args) {
        Session session = HibernateUtil.getConfiguration().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.eq("certificate.course", "Java Hibernate Course"));
        List<Student> studentList = criteria.list();

        for(Student student : studentList){
            System.out.println(student);
        }

        transaction.commit();
        session.close();
    }
}
