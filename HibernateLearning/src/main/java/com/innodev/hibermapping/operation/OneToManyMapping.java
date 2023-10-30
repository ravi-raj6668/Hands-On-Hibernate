package com.innodev.hibermapping.operation;

import com.innodev.hibermapping.entity.AnswerOM_MO;
import com.innodev.hibermapping.entity.QuestionOM_MO;
import com.innodev.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class OneToManyMapping {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

//        creating question
        QuestionOM_MO question1 = new QuestionOM_MO();
        question1.setQuestion("What is Java?");

        //creating answer
        AnswerOM_MO answer1 = new AnswerOM_MO();
        answer1.setAnswer("Java is programming language");
        answer1.setQuestion(question1);

        AnswerOM_MO answer2 = new AnswerOM_MO();
        answer2.setAnswer("Java helps to create web app");
        answer2.setQuestion(question1);

        AnswerOM_MO answer3 = new AnswerOM_MO();
        answer3.setAnswer("Java has OOPS concept");
        answer3.setQuestion(question1);

        List<AnswerOM_MO> answerOMMoList = new ArrayList<>();
        answerOMMoList.add(answer1);
        answerOMMoList.add(answer2);
        answerOMMoList.add(answer3);

        question1.setAnswer(answerOMMoList);

        // session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //save
        session.save(question1);

        session.save(answer1);
        session.save(answer2);
        session.save(answer3);

//        fetching

        QuestionOM_MO questionOMMo1 = session.load(QuestionOM_MO.class,1);
        System.out.println(questionOMMo1.getQuestion());
        for(AnswerOM_MO a : questionOMMo1.getAnswer()){
            System.out.println(a.getAnswer());
        }

        //lazy loading and eager loading -> by default the fetching type will be LAZY we can make EAGER explicitly.


        QuestionOM_MO questionOMMo = session.get(QuestionOM_MO.class,1);
        System.out.println(questionOMMo.getQuestionId());
        System.out.println(questionOMMo.getQuestion());
        System.out.println(questionOMMo.getAnswer().size());

        transaction.commit();

        session.close();
        sessionFactory.close();


    }
}
