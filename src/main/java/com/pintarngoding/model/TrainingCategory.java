package com.pintarngoding.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "m_trainer_category")
public class TrainingCategory {
    @Id
    @Column(name = "id_training_category")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTrainingCategory;

    @Column(name = "name_category", nullable = false, length = 100)
    private String nameCategory;

    @OneToMany(mappedBy = "trainingCategory")
    private List<ClassTraining> classTrainings = new ArrayList<>();

    /**
     *
     * getter and setter
     */

    public Integer getIdTrainingCategory() {
        return idTrainingCategory;
    }

    public void setIdTrainingCategory(Integer idTrainingCategory) {
        this.idTrainingCategory = idTrainingCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public String toString() {
        return "TrainingCategory{" +
                "idTrainingCategory=" + idTrainingCategory +
                ", nameCategory='" + nameCategory + '\'' +
                '}';
    }
}
