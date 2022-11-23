package com.pintarngoding.repository;

import com.pintarngoding.model.Student;

import java.util.List;

public interface StudentRepository<S> extends BaseRepository<Student>{
    @Override
    void create(Student data);

    Student findOne(String email);

    @Override
    List<Student> findAll();

    void remove(String email);
}
