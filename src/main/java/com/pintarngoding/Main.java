package com.pintarngoding;

import com.pintarngoding.config.JpaConfig;
import com.pintarngoding.model.*;
import com.pintarngoding.repository.IStudenntRepository;
import com.pintarngoding.repository.StudentRepository;
import com.pintarngoding.service.IStudentService;
import com.pintarngoding.service.StudentService;
import com.pintarngoding.ui.Menu;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaConfig.getEntityManager();

        /**
         * student
         */
        StudentRepository studentRepository = new IStudenntRepository(em);
        StudentService studentService = new IStudentService(studentRepository);
        Student student = new Student();
        StudentCredential studentCredential = new StudentCredential();

        /**
         * ClassTraining
         */
        Trainer trainer = new Trainer();
        Training training = new Training();
        TrainingCategory trainingCategory = new TrainingCategory();
        ClassTraining classTraining = new ClassTraining();

        /**
         * ui
         */
        Menu menu = new Menu(studentService, student, studentCredential);
        menu.landingApp();


        /**
         *
         */
        em.close();
    }
}