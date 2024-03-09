package com.example.demo.patient;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//Designing APIs
@RestController
@RequestMapping(path = "api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }

    @GetMapping(path = "{patientID}")
    public List<Patient> getPatient(@PathVariable ("patientID") Long patientID){
        return patientService.getPatients();}


    @PostMapping
    public void registerNewPatient(@RequestBody Patient patient){
        patientService.addNewPatient(patient);
    }

    @DeleteMapping(path = "{patientID}")
    public void deletePatient(
            @PathVariable("patientID") Long patientID){
        patientService.deletePatient(patientID);
    }

    @PutMapping(path = "{patientID}")
    public void updatePatientName(
            @PathVariable ("patientID") Long patientId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) int age

    ){
        patientService.updatePatientData(patientId, firstName, lastName, email, address);
    }

}
