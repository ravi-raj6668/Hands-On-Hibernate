package com.innodev.util;

import com.innodev.hibermapping.entity.*;
import com.innodev.hibernate.entity.Student;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final Configuration configuration;

    static {
        try{
            configuration = new Configuration();
            //configuration.setProperty("hibernate.dialect", "com.innodev.util.CustomPostgreSqlDialect");
            configuration.setProperty("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
            configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/test_db");
            configuration.setProperty("hibernate.connection.username", "postgres");
            configuration.setProperty("hibernate.connection.password", "root");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.format_sql", "true");
            configuration.setProperty("hibernate.cache.use_second_level_cache", "true");
            configuration.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");


            //adding entity mappings
            configuration.addAnnotatedClass(Student.class);
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
