package com.pintarngoding.repository;

import com.pintarngoding.model.Student;

import java.util.List;

public interface BaseRepository<T> {
    void create(T data);

    List<T> findAll();

}
