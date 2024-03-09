package com.example.demo.caregiver;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CaregiverConfig {

    @Bean
    CommandLineRunner caregiverCommandLineRunner(CaregiverRepository repository){
    return args -> {
                Caregiver ahmed = new Caregiver(
                    "Ahmed",
                        "Ali",
                        "01023436115"
                );

        Caregiver islam = new Caregiver(
                "Islam",
                "Ali",
                "01023436115"
        );

           repository.saveAll(
                   List.of(ahmed,islam)
           );
        };
    }
}
