package com.innodev.sql;

import com.innodev.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public class SQLExample {
    public static void main(String[] args) throws Exception {
        SessionFactory sessionFactory = null;

        Session session = null;
        try {
            sessionFactory = HibernateUtil.getConfiguration().buildSessionFactory();
            session = sessionFactory.openSession();

            //SQL query
            String query = "select * from student";

            NativeQuery<Object[]> nativeQuery = session.createSQLQuery(query);

            List<Object[]> studentList = nativeQuery.list();

            for (Object[] student : studentList) {
                System.out.println(Arrays.deepToString(student));
            }
        } catch (Exception e) {
            System.out.println("Error while fetching data : " + e.getMessage());
            throw new Exception(e);

        } finally {
            if (session != null) {
                session.close();
            }

            if (session != null) {
                sessionFactory.close();
            }

        }


    }
}
