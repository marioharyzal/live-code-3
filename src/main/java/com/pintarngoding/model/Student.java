package com.pintarngoding.model;

import com.pintarngoding.constant.LastEducation;
import com.pintarngoding.constant.StudentStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "call_name", nullable = false, length = 50)
    private String callName;

    @Column(name = "residence_address", nullable = false)
    private String residenceAddress;

    @Column(name = "no_hp", nullable = false, length = 12)
    private String noHp;

    @Column(name = "no_ktp", nullable = false, length = 50)
    private String noKtp;

    @Column(columnDefinition = "varchar(20)", name = "last_education")
    @Enumerated(EnumType.STRING)
    private LastEducation lastEducation;

    @Column(columnDefinition = "varchar(5)", name = "is_active")
    @Enumerated(EnumType.STRING)
    private StudentStatus isActive;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_credential")
    private StudentCredential studentCredential;

    /**
     * getter and setter
     *
     */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCallName() {
        return callName;
    }

    public void setCallName(String callName) {
        this.callName = callName;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public LastEducation getLastEducation() {
        return lastEducation;
    }

    public void setLastEducation(LastEducation lastEducation) {
        this.lastEducation = lastEducation;
    }

    public StudentStatus getIsActive() {
        return isActive;
    }

    public void setIsActive(StudentStatus isActive) {
        this.isActive = isActive;
    }

    public StudentCredential getStudentCredential() {
        return studentCredential;
    }

    public void setStudentCredential(StudentCredential studentCredential) {
        this.studentCredential = studentCredential;
    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", callName='" + callName + '\'' +
                ", residenceAddress='" + residenceAddress + '\'' +
                ", noHp='" + noHp + '\'' +
                ", noKtp='" + noKtp + '\'' +
                ", lastEducation=" + lastEducation +
                ", isActive=" + isActive +
                ", studentCredential=" + studentCredential +
                '}';
    }
}
