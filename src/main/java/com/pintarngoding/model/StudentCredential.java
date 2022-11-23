package com.pintarngoding.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sys_student_authentication")
public class StudentCredential {
    @Id
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "studentCredential")
    private Student student;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentCredential{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", student=" + student +
                '}';
    }
}
