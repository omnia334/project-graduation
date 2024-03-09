package com.example.demo.medicine;

import com.example.demo.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    @Query("SELECT m FROM Medicine m WHERE m.medicine_name = ?1")
    Optional<Medicine> findMedicineByName(String medicineName);
}
