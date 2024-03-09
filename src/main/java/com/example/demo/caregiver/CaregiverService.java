package com.example.demo.caregiver;

import com.example.demo.medicine.Medicine;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CaregiverService {

    private final CaregiverRepository caregiverRepository;

    public CaregiverService(CaregiverRepository caregiverRepository) {
        this.caregiverRepository = caregiverRepository;
    }

    public List<Caregiver> getCaregivers(){
        return caregiverRepository.findAll();
    }

      public Optional<Caregiver> getCaregiver(Long caregiverID){
      return caregiverRepository.findById(caregiverID);}


    public void addNewCaregiver(Caregiver caregiver){
        Optional<Caregiver> caregiver1FindByName = caregiverRepository.findCaregiverByName(caregiver.getFirstName());
        if(caregiver1FindByName.isPresent()){
            throw new IllegalStateException("This caregiver added before, please add another one");
        }
        caregiverRepository.save(caregiver);
    }

    public void deleteCaregiver(Long caregiverID){
        Boolean exists = caregiverRepository.existsById(caregiverID);
        if (!exists){
            throw new IllegalStateException("the patient with id " + caregiverID + " does not exist");
        }

        caregiverRepository.deleteById(caregiverID);
    }


    @Transactional
    public void updateCaregiverData(Long caregiverID,
                                   String firstName,
                                   String lastName,
                                   String phoneNumber ){

        Caregiver caregiver = caregiverRepository.findById(caregiverID).orElseThrow(() ->
                new IllegalStateException("the patient id" + caregiverID + "does not exist"));

        if (firstName != null && !firstName.isEmpty()
                && !Objects.equals(caregiver.getFirstName(),firstName)){
            caregiver.setFirstName(firstName);}

        if (lastName != null && !lastName.isEmpty()
                && !Objects.equals(caregiver.getLastName(),lastName)){
            caregiver.setLastName(lastName);}

        if (phoneNumber != null && !phoneNumber.isEmpty()
                && !Objects.equals(caregiver.getPhoneNumber(),phoneNumber)){
            caregiver.setPhoneNumber(phoneNumber);
        }


    }


}
