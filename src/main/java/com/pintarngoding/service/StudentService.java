package com.pintarngoding.service;

import com.pintarngoding.model.Student;
import com.pintarngoding.model.StudentCredential;
import com.pintarngoding.utils.response.ResponseStatus;

public interface StudentService extends BaseService<Student>{
    ResponseStatus<Student> getOneData(StudentCredential student);

    ResponseStatus deleteData(String email);
}
