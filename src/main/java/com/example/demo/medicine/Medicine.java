package com.example.demo.medicine;

import com.example.demo.doctor.Doctor;
import com.example.demo.patient.Patient;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity(name = "Medicine")
@Table
public class Medicine {

    @Id
    @SequenceGenerator(
            name = "medicine_sequence",
            sequenceName = "medicine_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "medicine_sequence"
    )
    @Column(
            name="medicineid",
            updatable = false
    )
    private Long medicineID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "fk_doctor_id")
    private Doctor doctor;

    @Column(
            name = "dosage",
            columnDefinition = "TEXT"
    )
    private String dosage;
    @Column(
            name = "frequency",
            columnDefinition = "TEXT"
    )
    private String frequency;
    @Column(
            name = "start_date",
            columnDefinition = "TEXT"
    )
    private LocalDate start_date;
    @Column(
            name = "end_date",
            columnDefinition = "TEXT"
    )
    private LocalDate end_date;
    @Column(
            name = "medcinine_name",
            columnDefinition = "TEXT"

    )
    private String medicine_name;

    public Medicine() {
    }

    public Medicine(Long medicineID,
                    String dosage,
                    String frequency,
                    LocalDate start_date,
                    LocalDate end_date,
                    String medicine_name) {
        this.medicineID = medicineID;
        this.dosage = dosage;
        this.frequency = frequency;
        this.start_date = start_date;
        this.end_date = end_date;
        this.medicine_name = medicine_name;
    }

    public Medicine(String dosage,
                    String frequency,
                    LocalDate start_date,
                    LocalDate end_date,
                    String medicine_name) {
        this.dosage = dosage;
        this.frequency = frequency;
        this.start_date = start_date;
        this.end_date = end_date;
        this.medicine_name = medicine_name;
    }

    public void setMedicineID(Long medicineID) {
        this.medicineID = medicineID;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public void setMedicine_name(String name) {
        this.medicine_name = name;
    }

    public Long getMedicineID() {
        return medicineID;
    }

    public String getDosage() {
        return dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public String getMedicine_name() {
        return medicine_name;
    }
}
