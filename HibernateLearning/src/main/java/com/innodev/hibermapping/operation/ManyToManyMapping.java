package com.innodev.hibermapping.operation;

import com.innodev.hibermapping.entity.Employee;
import com.innodev.hibermapping.entity.Project;
import com.innodev.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ManyToManyMapping {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        employee1.setName("Ravi");
        employee2.setName("Saras");

        Project project1 = new Project();
        Project project2 = new Project();

        project1.setProjectName("Library Management System");
        project2.setProjectName("Student Management System");

        List<Employee> employeeList = new ArrayList<>();
        List<Project> projectList = new ArrayList<>();

        employeeList.add(employee1);
        employeeList.add(employee2);

        projectList.add(project1);
        projectList.add(project2);

        employee1.setProjectList(projectList);
        project2.setEmployees(employeeList);

        employee2.setProjectList(projectList);
        project1.setEmployees(employeeList);


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(employee1);
        session.save(employee2);

        session.save(project1);
        session.save(project2);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
