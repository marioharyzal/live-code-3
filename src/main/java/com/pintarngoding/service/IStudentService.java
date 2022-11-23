package com.pintarngoding.service;

import com.pintarngoding.constant.ResponseMsg;
import com.pintarngoding.model.Student;
import com.pintarngoding.model.StudentCredential;
import com.pintarngoding.repository.StudentRepository;
import com.pintarngoding.utils.response.FailedResponse;
import com.pintarngoding.utils.response.ResponseStatus;
import com.pintarngoding.utils.response.SuccessResponse;

import java.util.List;

public class IStudentService implements StudentService {

    StudentRepository studentRepository;

    public IStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseStatus addData(Student student) {
        try {
            studentRepository.create(student);
            return new SuccessResponse(ResponseMsg.SUCCESS.toString(), null);
        } catch (Exception e) {
            return new FailedResponse(ResponseMsg.FAILED.toString() + " " + e.getMessage());
        }
    }

    @Override
    public ResponseStatus<List<Student>> getAllData() {
        return null;
    }

    @Override
    public ResponseStatus<Student> getOneData(StudentCredential inputStudent) {
        try {
            Student student = studentRepository.findOne(inputStudent.getEmail());
            if (student.getEmail().isEmpty()) {
                throw new Exception(ResponseMsg.EMPTY.toString());
            } else if (student.getEmail().equals(inputStudent.getEmail()) && student.getStudentCredential().getPassword().equals(inputStudent.getPassword())) {
                return new SuccessResponse<Student>(ResponseMsg.SUCCESS.toString(), student);
            } else {
                throw new Exception(ResponseMsg.EMPTY.toString());
            }
        } catch (Exception e) {
            return new FailedResponse<>(ResponseMsg.FAILED.toString() + " " + ResponseMsg.EMPTY.toString());
        }
    }

    @Override
    public ResponseStatus deleteData(String email) {
        return null;
    }
}
