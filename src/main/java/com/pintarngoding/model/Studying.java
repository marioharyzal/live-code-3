package com.pintarngoding.model;

import com.pintarngoding.constant.StudentStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studying")
public class Studying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudying;

    @Column(columnDefinition = "varchar(5)", name = "is_active_studying")
    @Enumerated(EnumType.STRING)
    private StudentStatus isActive;

    @ManyToOne
    @MapsId("email")
    @JoinColumn(name = "email")
    private Student student;

    @ManyToOne
    @MapsId("idClass")
    @JoinColumn(name = "id_class")
    private ClassTraining classTraining;

    @OneToMany(mappedBy = "grade")
    private List<Grade> grades = new ArrayList<>();

    /**
     *
     * getter and setter
     */

    public Integer getIdStudying() {
        return idStudying;
    }

    public void setIdStudying(Integer idStudying) {
        this.idStudying = idStudying;
    }

    public void setIsActive(StudentStatus isActive) {
        this.isActive = isActive;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ClassTraining getClassTraining() {
        return classTraining;
    }

    public void setClassTraining(ClassTraining classTraining) {
        this.classTraining = classTraining;
    }

    @Override
    public String toString() {
        return "Studying{" +
                "idStudying=" + idStudying +
                ", isActive='" + isActive + '\'' +
                ", student=" + student +
                ", classTraining=" + classTraining +
                '}';
    }
}
