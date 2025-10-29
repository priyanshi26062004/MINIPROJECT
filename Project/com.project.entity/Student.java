package com.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String department;
    private double fees;

    public Student() {}

    public Student(String name, String department, double fees) {
        this.name = name;
        this.department = department;
        this.fees = fees;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public double getFees() { return fees; }
    public void setFees(double fees) { this.fees = fees; }
}
