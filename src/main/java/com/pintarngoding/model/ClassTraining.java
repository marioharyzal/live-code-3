package com.pintarngoding.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "m_class")
public class ClassTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClass;

    @Temporal(TemporalType.DATE)
    @Column(name = "class_start")
    private Date classStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "class_end")
    private Date classEnd;

    @ManyToOne
    @MapsId("idTrainer")
    @JoinColumn(name = "id_trainer")
    Trainer trainer;

    @ManyToOne
    @MapsId("idTraining")
    @JoinColumn(name = "id_training")
    Training training;

    @ManyToOne
    @MapsId("idTrainingCategory")
    @JoinColumn(name = "id_training_category")
    TrainingCategory trainingCategory;

    /**
     *
     * getter and setter
     */

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    public Date getClassStart() {
        return classStart;
    }

    public void setClassStart(Date classStart) {
        this.classStart = classStart;
    }

    public Date getClassEnd() {
        return classEnd;
    }

    public void setClassEnd(Date classEnd) {
        this.classEnd = classEnd;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public TrainingCategory getTrainingCategory() {
        return trainingCategory;
    }

    public void setTrainingCategory(TrainingCategory trainingCategory) {
        this.trainingCategory = trainingCategory;
    }

    @Override
    public String toString() {
        return "ClassTraining{" +
                "idClass=" + idClass +
                ", classStart=" + classStart +
                ", classEnd=" + classEnd +
                ", trainer=" + trainer +
                ", training=" + training +
                ", trainingCategory=" + trainingCategory +
                '}';
    }
}
