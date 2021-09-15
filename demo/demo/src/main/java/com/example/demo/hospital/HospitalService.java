package com.example.demo.hospital;

import com.example.demo.exception.HospitalNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    private HospitalDataAccessServicePG hospitalDataAccessService;

    public HospitalService(HospitalDataAccessServicePG hospitalDataAccessService) {
        this.hospitalDataAccessService = hospitalDataAccessService;
    }

    public List<Hospital> getHospitals() {
        return hospitalDataAccessService.selectAllHospitals();
    }

    public void addNewHospital(Hospital hospital) {
        int result = hospitalDataAccessService.insertHospital(hospital);
        if (result != 1) {
            throw new IllegalStateException("Error - please try again. Make sure all information entered is correct.");
        }
    }

    public Hospital getHospital(Long hospitalID) {
        return hospitalDataAccessService.selectAllHospitals()
                .stream()
                .filter(hospital -> hospital.getHospitalID().equals(hospitalID))
                .findFirst()
                .orElseThrow(() -> new HospitalNotFoundException("Hospital ID " + hospitalID + " not found"));
    }

    public void deleteHospital(Long hospitalID) {
        boolean hospitalExists = false;
        for (Hospital hospital : hospitalDataAccessService.selectAllHospitals()) {
            if (hospital.getHospitalID().equals(hospitalID)) {
                hospitalExists = true;
                hospitalDataAccessService.deleteHospital(hospital);
            }
        }
        if (!hospitalExists) {
            throw new HospitalNotFoundException("Hospital ID " + hospitalID + " not found");
        }
    }

    public void updateHospital(Hospital hospital) {
        boolean hospitalExists = false;
        for (Hospital hospitalInDB : hospitalDataAccessService.selectAllHospitals()) {
            if (hospitalInDB.getHospitalID().equals(hospital.getHospitalID())) {
                hospitalExists = true;
                hospitalInDB.setHospitalName(hospital.getHospitalName());
                hospitalInDB.setStreet(hospital.getStreet());
                hospitalInDB.setCity(hospital.getCity());
                hospitalInDB.setState(hospital.getState());
                hospitalInDB.setCountry(hospital.getCountry());
                hospital.setPostalCode(hospital.getPostalCode());
            }
        }
        if (!hospitalExists) {
            throw new HospitalNotFoundException("Hospital not found");
        }
    }

}
