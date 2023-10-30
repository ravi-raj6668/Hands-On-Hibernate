package com.innodev.hibermapping.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "e_id")
    private int id;
    @Column(name = "employee_name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = {@JoinColumn (name = "employees_id")},
            inverseJoinColumns = {@JoinColumn(name = "projects_id")}
    )
    private List<Project> projectList;

    public Employee() {
    }

    public Employee(int id, String name, List<Project> projectList) {
        this.id = id;
        this.name = name;
        this.projectList = projectList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", projectList=" + projectList +
                '}';
    }
}
