package com.example.demo.patient;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

//Modeling the Patient
@Entity(name = "Patient")
@Table
public class Patient {

    @Id
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )
    @Column(
            name="patientid",
            updatable = false
    )
    private Long patientID;
    @Column(
            name="first_name",
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name="last_name",
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(
            name="address",
            columnDefinition = "TEXT"
    )
    private String address;
    @Column(name="date")
    private LocalDate dob;
    @Transient
    private int age;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Patient() {
    }

    public Patient(
                   String firstName,
                   String lastName,
                   String email,
                   String address,
                   LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.dob = dob;

    }

    public Patient(String firstName,
                   String lastName,
                   String address,
                   LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dob = dob;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getPatientID() {
        return patientID;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public int getAge() {
        return Period.between(dob,LocalDate.now()).getYears();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patientID=" + patientID +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
