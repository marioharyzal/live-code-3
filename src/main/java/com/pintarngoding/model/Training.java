package com.pintarngoding.model;

import com.pintarngoding.constant.TrainingStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "m_training")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_training")
    private Integer idTraining;

    @Column(name = "training_name", nullable = false, length = 100)
    private String trainingName;

    @Column(name = "desc", nullable = false, length = 255)
    private String desc;

    @Column(name = "training_type", columnDefinition = "varchar(4)")
    private TrainingStatus trainingType;

    @Column(name = "min_standart_grade")
    private Integer minStandartGrade;

    @OneToMany(mappedBy = "training")
    private List<ClassTraining> trainings = new ArrayList<>();

    /**
     * getter and setter
     */


    public Integer getIdTraining() {
        return idTraining;
    }

    public void setIdTraining(Integer idTraining) {
        this.idTraining = idTraining;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public TrainingStatus getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(TrainingStatus trainingType) {
        this.trainingType = trainingType;
    }

    public Integer getMinStandartGrade() {
        return minStandartGrade;
    }

    public void setMinStandartGrade(Integer minStandartGrade) {
        this.minStandartGrade = minStandartGrade;
    }

    @Override
    public String toString() {
        return "Training{" +
                "idTraining=" + idTraining +
                ", trainingName='" + trainingName + '\'' +
                ", desc='" + desc + '\'' +
                ", trainingType=" + trainingType +
                ", minStandartGrade=" + minStandartGrade +
                '}';
    }
}
