package com.example.demo.medicine;

import com.example.demo.patient.Patient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/medicine")
public class MedicineController {
    private final MedicineService medicineService;


    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping
    public List<Medicine> getMedicine(){
        return medicineService.getMedicine();
    }

    @PostMapping
    public void registerNewPatient(@RequestBody Medicine medicine){
        medicineService.addNewMedicine(medicine);
    }

    @DeleteMapping(path = "{medicineID}")
    public void deletePatient(
            @PathVariable("medicineID") Long medicineID){
        medicineService.deletePatient(medicineID);
    }

    @PutMapping(path = "{medicineID}")
    public void updatePatientName(
            @PathVariable ("medicineID") Long medicineId,
            @RequestParam(required = false) String dosage,
            @RequestParam(required = false) String frequency,
            @RequestParam(required = false) LocalDate start_date,
            @RequestParam(required = false) LocalDate end_date,
            @RequestParam(required = false) String medicineName

    ){
        medicineService.updateMedicineData(medicineId, dosage, frequency, start_date, end_date,medicineName);
    }

}
