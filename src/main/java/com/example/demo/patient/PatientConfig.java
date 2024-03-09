package com.example.demo.patient;

import com.example.demo.caregiver.Caregiver;
import com.example.demo.caregiver.CaregiverRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PatientConfig {

    @Bean
    CommandLineRunner patientCommandLineRunner(PatientRepository repository){
    return args -> {
        Patient kamal = new Patient(
                "Kamel",
                "Farouk",
                "kamal@gmail.com",
                "2 Beni-Suef",
                LocalDate.of(1988, Month.FEBRUARY, 3)
        );

        Patient Amira = new Patient(
                "Amira",
                "Samir",
                "Amira@gmail.com",
                "Cairo",
                LocalDate.of(1978, Month.APRIL, 4)
        );

           repository.saveAll(
                   List.of(kamal,Amira)
           );
        };
    }
}
