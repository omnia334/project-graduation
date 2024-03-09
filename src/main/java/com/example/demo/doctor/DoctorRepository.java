package com.example.demo.doctor;

import com.example.demo.caregiver.Caregiver;
import com.example.demo.medicine.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT m FROM Doctor m WHERE m.firstName = ?1")
    Optional<Doctor> findDoctorByName(String firstName);
}
