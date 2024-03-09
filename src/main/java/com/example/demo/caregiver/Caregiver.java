package com.example.demo.caregiver;

import com.example.demo.patient.Patient;
import jakarta.persistence.*;

@Entity(name = "Caregiver")
@Table
public class Caregiver {
    @Id
    @SequenceGenerator(
            name = "caregiver_sequence",
            sequenceName = "caregiver_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "caregiver_sequence"
    )
    @Column(
            name="caregiverid",
            updatable = false
    )
    private int caregiverID;
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

    @ManyToOne
    @JoinColumn(name = "fk_patient_id")
    private Patient patient;


    public Caregiver() {
    }

    public Caregiver(int caregiverID,
                     String firstName,
                     String lastName,
                     String phoneNumber) {
        this.caregiverID = caregiverID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Caregiver(String firstName,
                     String lastName,
                     String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public void setCaregiverID(int caregiverID) {
        this.caregiverID = caregiverID;
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

    public int getCaregiverID() {
        return caregiverID;
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
        return "Caregiver{" +
                "caregiverID=" + caregiverID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
