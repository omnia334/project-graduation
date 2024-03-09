package com.example.demo.doctor;

import com.example.demo.medicine.Medicine;
import com.example.demo.patient.Patient;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Doctor")
@Table
public class Doctor {

    @Id
    @SequenceGenerator(
            name = "doctor_sequence",
            sequenceName = "doctor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doctor_sequence"
    )
    @Column(
            name="doctorid",
            updatable = false
    )
    private Long doctorID;

    @ManyToOne
    @JoinColumn(name="fk_patient_id")
    private Patient patient;

    @OneToMany
    @JoinColumn(name = "fk_medicine_id")
    private Set<Medicine> medicine = new HashSet<>();

    @Column(
            name = "department",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String department;

    @Column(
            name = "fisrt_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String lastName;
    @Column(
            name = "phone_number",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String phoneNumber;

    public Doctor() {
    }

    public Doctor(String department,
                  String firstName,
                  String lastName,
                  String phoneNumber) {
        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Doctor(Long doctorID,
                  String department,
                  String firstName,
                  String lastName,
                  String phoneNumber) {
        this.doctorID = doctorID;
        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public void setDoctorID(Long doctorID) {
        this.doctorID = doctorID;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getDoctorID() {
        return doctorID;
    }

    public String getDepartment() {
        return department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID=" + doctorID +
                ", department='" + department + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
