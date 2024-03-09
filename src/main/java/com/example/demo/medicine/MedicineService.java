package com.example.demo.medicine;

import com.example.demo.patient.Patient;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MedicineService {
    private final MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public List<Medicine> getMedicine(){
    return medicineRepository.findAll();
    }

    public void addNewMedicine(Medicine medicine){
        Optional<Medicine> medicineFindByName = medicineRepository.findMedicineByName(medicine.getMedicine_name());
        if(medicineFindByName.isPresent()){
            throw new IllegalStateException("This medicine added before, please add another one");
        }
        medicineRepository.save(medicine);
    }

    public void deletePatient(Long medicineId) {
        Boolean exists = medicineRepository.existsById(medicineId);
        if (!exists) {
            throw new IllegalStateException("the patient with id " + medicineId + " does not exist");
        }

        medicineRepository.deleteById(medicineId);
    }


    @Transactional
    public void updateMedicineData(Long medicineId,
                                  String dosage,
                                  String frequency,
                                  LocalDate start_date,
                                  LocalDate end_date,
                                  String medicine_name ){

        Medicine medicine = medicineRepository.findById(medicineId).orElseThrow(() ->
                new IllegalStateException("the patient id" + medicineId + "does not exist"));

        if (dosage != null && !dosage.isEmpty()
                && !Objects.equals(medicine.getDosage(),dosage)){
            medicine.setDosage(dosage);}

        if (frequency != null && !frequency.isEmpty()
                && !Objects.equals(medicine.getFrequency(),frequency)){
            medicine.setFrequency(frequency);}

        if (start_date != null && !start_date.isBefore(LocalDate.now())
                && !Objects.equals(medicine.getStart_date(),start_date)){
            medicine.setStart_date(start_date);
        }

        if (end_date != null && !end_date.isBefore(LocalDate.now())
                && !Objects.equals(medicine.getEnd_date(),end_date)){
            medicine.setEnd_date(end_date);
        }

        if (medicine_name != null && !medicine_name.isEmpty()
                && !Objects.equals(medicine.getMedicine_name(),medicine_name)){
            medicine.setMedicine_name(medicine_name);
        }
    }

}
