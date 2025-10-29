package com.project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.project.config.AppConfig;
import com.project.entity.Student;
import com.project.service.StudentService;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentService service = context.getBean(StudentService.class);

        // Add students
        service.addStudent(new Student("Riya Sharma", "CSE", 25000));
        service.addStudent(new Student("Arjun Patel", "ECE", 22000));

        // Display records
        service.showStudents();

        // Perform transactions
        service.updateFees(1, 5000, false); // Payment
        service.updateFees(2, 3000, true);  // Refund

        // Display after transaction
        System.out.println("\nAfter transactions:");
        service.showStudents();

        context.close();
    }
}
