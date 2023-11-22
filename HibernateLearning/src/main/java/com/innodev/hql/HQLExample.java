package com.innodev.hql;

import com.innodev.hibernate.entity.Student;
import com.innodev.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class HQLExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getConfiguration().buildSessionFactory();

        Session session = sessionFactory.openSession();
        // HQL

        System.out.println("--------------select Query---------------");
        String query = "from Student where city = :city and name = :name";

        Query<Student> q = session.createQuery(query, Student.class);
        q.setParameter("city", "Bangalore");
        q.setParameter("name", "Saras");
        List<Student> studentList = q.list();

        for (Student student : studentList) {
            System.out.println(student.getCertificate().getCourse());
        }

        System.out.println("---------------Delete query----------------");

        Transaction transaction = session.beginTransaction();
        int rowsDeleted = session.createQuery("delete from Student s where s.city = :city").setParameter("city", "Bangalore1").executeUpdate();
        System.out.println("Deleted data : " + rowsDeleted);

        System.out.println("----------Update query-------------");

        int rowsUpdated = session.createQuery("update Student set city = :city where name = :name")
                .setParameter("city", "TEZU")
                .setParameter("name", "Saras")
                .executeUpdate();
        System.out.println("Updated Rows : " + rowsUpdated);


        //join column
        @SuppressWarnings("unchecked")
        Query<Object[]> q4 = session.createQuery("select q.question, q.questionId, a.answer from QuestionOM_MO q INNER JOIN q.answer a ");
        List<Object[]> list = q4.getResultList();
        for (Object[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
