public package com.project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.dao.StudentDAO;
import com.project.entity.Student;

@Service
public class StudentService {
    private StudentDAO dao;

    public StudentService(StudentDAO dao) {
        this.dao = dao;
    }

    @Transactional
    public void addStudent(Student s) {
        dao.saveStudent(s);
    }

    @Transactional
    public void updateFees(int id, double amount, boolean isRefund) {
        Student s = dao.getStudent(id);
        if (s == null) throw new RuntimeException("Student not found!");

        if (isRefund) {
            s.setFees(s.getFees() - amount);
        } else {
            s.setFees(s.getFees() + amount);
        }
        dao.saveStudent(s);
    }

    @Transactional(readOnly = true)
    public void showStudents() {
        for (Student s : dao.listStudents()) {
            System.out.println(s.getId() + " | " + s.getName() + " | " + s.getDepartment() + " | Fees: " + s.getFees());
        }
    }
}

