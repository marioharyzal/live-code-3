package com.pintarngoding.repository;

import com.pintarngoding.model.Student;
import jakarta.persistence.EntityManager;

import java.util.List;

public class IStudenntRepository implements StudentRepository<Student>{

    EntityManager entityManager;

    public IStudenntRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Student student) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findOne(String email) {
        try {
            Student student = entityManager.find(Student.class, email);
            return student;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void remove(String email) {

    }
}
