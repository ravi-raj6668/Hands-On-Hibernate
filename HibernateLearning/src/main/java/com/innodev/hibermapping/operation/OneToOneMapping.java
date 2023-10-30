package com.innodev.hibermapping.operation;

import com.innodev.hibermapping.entity.Answer;
import com.innodev.hibermapping.entity.Question;
import com.innodev.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToOneMapping {
    public static void main(String[] args) {
//        Configuration cfg = new Configuration();
//        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        cfg.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
//        cfg.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/test_db");
//        cfg.setProperty("hibernate.connection.username", "postgres");
//        cfg.setProperty("hibernate.connection.password", "root");
//        cfg.setProperty("hibernate.hbm2ddl.auto", "create");
//        cfg.setProperty("hibernate.show_sql", "true");
//        cfg.setProperty("hibernate.format_sql", "true");
//        cfg.addAnnotatedClass(Question.class);
//        cfg.addAnnotatedClass(Answer.class);

//        SessionFactory sessionFactory = cfg.buildSessionFactory();

        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

        //creating question
        Question question1 = new Question();
        question1.setQuestion("What is Java?");

        Question question2 = new Question();
        question2.setQuestion("What is Collection Framework?");


        //creating answer
        Answer answer1 = new Answer();
        answer1.setAnswer("Java is programming language");
        question1.setAnswer(answer1);

        Answer answer2 = new Answer();
        answer2.setAnswer("API to work with JAVA");
        question2.setAnswer(answer2);

        //start session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //saving the object
        session.save(question1);
        session.save(question2);

        session.save(answer1);
        session.save(answer2);

        transaction.commit();

        //fething data....
        Question newQues = session.load(Question.class, 1);
        System.out.println(newQues);
        session.close();
        sessionFactory.close();
    }
}
