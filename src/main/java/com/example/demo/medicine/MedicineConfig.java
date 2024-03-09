package com.example.demo.medicine;

import com.example.demo.doctor.Doctor;
import com.example.demo.doctor.DoctorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class MedicineConfig {

    @Bean
    CommandLineRunner medicineCommandLineRunner(MedicineRepository repository){
    return args -> {

        Medicine panadol = new Medicine(
                "20 Gram",
                "Twice/Day",
                LocalDate.of(2024, Month.FEBRUARY,3),
                LocalDate.of(2024,Month.APRIL,5),
                        "Panadol");

           repository.saveAll(
                   List.of(panadol)
           );
        };
    }
}
