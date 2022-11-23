package com.pintarngoding.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "m_trainer")
public class Trainer {
    @Id
    @Column(name = "id_trainer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTrainer;
    @Column(name = "trainer_name", nullable = false, length = 100)
    private String trainerName;

    @OneToMany(mappedBy = "trainer")
    private List<ClassTraining> trainers = new ArrayList<>();

    /**
     *
     * getter and setter
     */

    public Integer getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(Integer idTrainer) {
        this.idTrainer = idTrainer;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "idTrainer=" + idTrainer +
                ", trainerName='" + trainerName + '\'' +
                '}';
    }
}
