package com.innodev.util;

import com.innodev.hibermapping.entity.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final Configuration configuration;

    static {
        try{
            configuration = new Configuration();
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/test_db");
            configuration.setProperty("hibernate.connection.username", "postgres");
            configuration.setProperty("hibernate.connection.password", "root");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.format_sql", "true");



            //adding entity mappings
            configuration.addAnnotatedClass(Answer.class);
            configuration.addAnnotatedClass(Question.class);
            configuration.addAnnotatedClass(AnswerOM_MO.class);
            configuration.addAnnotatedClass(QuestionOM_MO.class);

            //many to many mapping entity class
            configuration.addAnnotatedClass(Employee.class);
            configuration.addAnnotatedClass(Project.class);
        }catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }
    public static Configuration getConfiguration(){
        return configuration;
    }
}
