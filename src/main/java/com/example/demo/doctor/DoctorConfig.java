package com.example.demo.doctor;

import com.example.demo.caregiver.Caregiver;
import com.example.demo.caregiver.CaregiverRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DoctorConfig {

    @Bean
    CommandLineRunner doctorCommandLineRunner(DoctorRepository repository){
    return args -> {

        Doctor ahmed = new Doctor(
                "Heart",
                "Ahmed",
                "Ali",
                "01023436115"
        );
        Doctor Karema = new Doctor(
                "Ear and Nose",
                "Karema",
                "Ali",
                "01023436115"
        );

           repository.saveAll(
                   List.of(ahmed,Karema)
           );
        };
    }
}
