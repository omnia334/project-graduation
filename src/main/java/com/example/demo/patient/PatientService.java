package com.example.demo.patient;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//Business Logic
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    private Patient patient;
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    public void addNewPatient(Patient patient){
        Optional<Patient> patientFindByEmail = patientRepository.findPatientByEmail(patient.getEmail());
        if(patientFindByEmail.isPresent()){
            throw new IllegalStateException("email taken please try another one");
        }
        patientRepository.save(patient);

        System.out.println(patient);
    }

    public void deletePatient(Long patientID){
        Boolean exists = patientRepository.existsById(patientID);
        if (!exists){
            throw new IllegalStateException("the patient with id " + patientID + " does not exist");
        }
        patientRepository.deleteById(patientID);
    }

    @Transactional
    public void updatePatientData(Long patientId,
                                  String firstName,
                                  String lastName,
                                  String email,
                                  String address ){

        Patient patient = patientRepository.findById(patientId).orElseThrow(() ->
                new IllegalStateException("the patient id" + patientId + "does not exist"));

        if (firstName != null && !firstName.isEmpty()
                && !Objects.equals(patient.getFirstName(),firstName)){
            patient.setFirstName(firstName);}

        if (lastName != null && !lastName.isEmpty()
                && !Objects.equals(patient.getLastName(),lastName)){
            patient.setLastName(lastName);}

        if (email != null && !email.isEmpty()
                && !Objects.equals(patient.getEmail(),email)){
            patient.setEmail(email);
        }

        if (address != null && !address.isEmpty()
                && !Objects.equals(patient.getAddress(),address)){
            patient.setAddress(address);
            }
    }

}
