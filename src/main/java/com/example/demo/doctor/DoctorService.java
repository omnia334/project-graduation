package com.example.demo.doctor;

import com.example.demo.caregiver.Caregiver;
import com.example.demo.medicine.Medicine;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.Optional;


import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctor(Long doctorID){
        return doctorRepository.findById(doctorID);}


    public void addNewDoctor(Doctor doctor){
        Optional<Doctor> doctor1FindByName = doctorRepository.findDoctorByName(doctor.getFirstName());
        if(doctor1FindByName.isPresent()){
            throw new IllegalStateException("This doctor added before, please add another one");
        }
        doctorRepository.save(doctor);
    }

    public void deletePatient(Long doctorID){
        Boolean exists = doctorRepository.existsById(doctorID);
        if (!exists){
            throw new IllegalStateException("the patient with id " + doctorID + " does not exist");
        }

        doctorRepository.deleteById(doctorID);
    }

    @Transactional
    public void updateDoctorData(Long doctorID,
                                   String department,
                                   String firstName,
                                   String lastName,
                                   String phoneNumber ){

        Doctor doctor = doctorRepository.findById(doctorID).orElseThrow(() ->
                new IllegalStateException("the patient id" + doctorID + "does not exist"));

        if (department != null && !department.isEmpty()
                && !Objects.equals(doctor.getDepartment(),department)){
            doctor.setDepartment(department);}

        if (firstName != null && !firstName.isEmpty()
                && !Objects.equals(doctor.getFirstName(),firstName)){
            doctor.setFirstName(firstName);}

        if (lastName != null && !lastName.isEmpty()
                && !Objects.equals(doctor.getLastName(),lastName)){
            doctor.setLastName(lastName);
        }

        if (phoneNumber != null && !phoneNumber.isEmpty()
                && !Objects.equals(doctor.getPhoneNumber(),phoneNumber)){
            doctor.setPhoneNumber(phoneNumber);
        }

    }



}
