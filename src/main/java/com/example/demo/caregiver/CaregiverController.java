package com.example.demo.caregiver;

import com.example.demo.doctor.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/caregivers")
public class CaregiverController {

    private final CaregiverService caregiverService;

    public CaregiverController(CaregiverService caregiverService) {
        this.caregiverService = caregiverService;
    }


    @GetMapping
    public List<Caregiver> getCaregivers(){
        return caregiverService.getCaregivers();
    }

    @GetMapping(path = "{caregiverID}")
    public Optional<Caregiver> getCaregiver(@PathVariable ("caregiverID") Long caregiverID){
        return caregiverService.getCaregiver(caregiverID);}

    @PostMapping
    public void registerNewPatient(@RequestBody Caregiver caregiver){
        caregiverService.addNewCaregiver(caregiver);
    }

    @DeleteMapping(path = "{caregiverID}")
    public void deletePatient(
            @PathVariable("caregiverID") Long caregiverID){
        caregiverService.deleteCaregiver(caregiverID);
    }

    @PutMapping(path = "{caregiverID}")
    public void updatePatientName(
            @PathVariable ("caregiverID") Long caregiverID,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String phoneNumber

    ){
        caregiverService.updateCaregiverData(caregiverID, firstName, lastName, phoneNumber);
    }
}
