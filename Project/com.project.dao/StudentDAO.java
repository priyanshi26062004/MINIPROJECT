package com.project.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.project.entity.Student;

@Repository
public class StudentDAO {
    private SessionFactory sessionFactory;

    public StudentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveStudent(Student s) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(s);
    }

    public Student getStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student s = session.get(Student.class, id);
        if (s != null) session.delete(s);
    }

    public List<Student> listStudents() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student", Student.class).list();
    }
}

