package com.example.demo.caregiver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CaregiverRepository extends JpaRepository<Caregiver, Long> {

    @Query("SELECT m FROM Caregiver m WHERE m.firstName = ?1")
    Optional<Caregiver> findCaregiverByName (String fisrtName);
}
