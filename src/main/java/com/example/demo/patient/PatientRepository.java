package com.example.demo.patient;

import com.example.demo.caregiver.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p.email = ?1")
    Optional<Patient> findPatientByEmail(String email);
}
