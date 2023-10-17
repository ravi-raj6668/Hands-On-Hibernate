package com.innodev.util;

import com.innodev.hibermapping.entity.Answer;
import com.innodev.hibermapping.entity.Question;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static Configuration configuration;

    static {
        try{
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/test_db");
            configuration.setProperty("hibernate.connection.username", "postgres");
            configuration.setProperty("hibernate.connection.password", "root");
            configuration.setProperty("hibernate.hbm2ddl.auto", "create");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.format_sql", "true");


            //adding entity mappings
            configuration.addAnnotatedClass(Answer.class);
            configuration.addAnnotatedClass(Question.class);
        }catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }
    public static Configuration getConfiguration(){
        return configuration;
    }
}
