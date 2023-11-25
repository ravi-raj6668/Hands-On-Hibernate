package com.innodev.cascading;

import com.innodev.hibermapping.entity.AnswerOM_MO;
import com.innodev.hibermapping.entity.QuestionOM_MO;
import com.innodev.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CascadingExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getConfiguration().buildSessionFactory();
        Session session = sessionFactory.openSession();

        QuestionOM_MO questionOMMo = new QuestionOM_MO();
        questionOMMo.setQuestion("Whats is Swing in Java ?");

        AnswerOM_MO answerOMMo = new AnswerOM_MO();
        answerOMMo.setAnswer("Swing is framework in java");
        answerOMMo.setQuestion(questionOMMo);

        AnswerOM_MO answerOMMo1 = new AnswerOM_MO();
        answerOMMo1.setAnswer("Used to create UI");
        answerOMMo1.setQuestion(questionOMMo);

        AnswerOM_MO answerOMMo2 = new AnswerOM_MO();
        answerOMMo2.setAnswer("For creating desktop applications");
        answerOMMo2.setQuestion(questionOMMo);

        List<AnswerOM_MO> answerOMMoList = new ArrayList<>();
        answerOMMoList.add(answerOMMo);
        answerOMMoList.add(answerOMMo1);
        answerOMMoList.add(answerOMMo2);

        questionOMMo.setAnswer(answerOMMoList);

        Transaction transaction = session.beginTransaction();

        session.save(questionOMMo);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
