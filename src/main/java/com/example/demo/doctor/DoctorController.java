package com.example.demo.doctor;

import com.example.demo.caregiver.Caregiver;
import com.example.demo.medicine.Medicine;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getDoctors(){
       return doctorService.getDoctors();
    }

    @GetMapping(path = "{doctorID}")
    public Optional<Doctor> getDoctor(@PathVariable ("doctorID") Long doctorID){
        return doctorService.getDoctor(doctorID);}


    @PostMapping
    public void registerNewPatient(@RequestBody Doctor doctor){
        doctorService.addNewDoctor(doctor);
    }

    @DeleteMapping(path = "{doctorID}")
    public void deletePatient(
            @PathVariable("doctorID") Long doctorID){
        doctorService.deletePatient(doctorID);
    }

    @PutMapping(path = "{doctorID}")
    public void updatePatientName(
            @PathVariable ("doctorID") Long doctorID,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String phoneNumber



    ){
        doctorService.updateDoctorData(doctorID, department, firstName, lastName, phoneNumber);
    }
}
