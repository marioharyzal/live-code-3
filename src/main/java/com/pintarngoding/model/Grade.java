package com.pintarngoding.model;

import jakarta.persistence.*;

@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGrade;
    @ManyToOne
    @MapsId("idStudying")
    @JoinColumn(name = "id_studying")
    private Studying idStudying;

    @Column(name = "grade", nullable = false, length = 3)
    private Integer grade;

    /**
     * getter and setter
     */

    public Integer getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(Integer idGrade) {
        this.idGrade = idGrade;
    }

    public Studying getIdStudying() {
        return idStudying;
    }

    public void setIdStudying(Studying idStudying) {
        this.idStudying = idStudying;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "idGrade=" + idGrade +
                ", idStudying=" + idStudying +
                ", grade=" + grade +
                '}';
    }
}
