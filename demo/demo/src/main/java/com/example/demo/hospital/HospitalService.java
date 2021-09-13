package com.example.demo.hospital;

import com.example.demo.exception.HospitalNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    private HospitalDataAccessService hospitalDataAccessService;

    public HospitalService(HospitalDataAccessService hospitalDataAccessService) {
        this.hospitalDataAccessService = hospitalDataAccessService;
    }

    public List<Hospital> getHospitals() {
        return hospitalDataAccessService.selectAllHospitals();
    }

    public void addNewHospital(Hospital hospital) {
        if (hospitalDataAccessService.selectAllHospitals().contains(hospital)) {
            throw new IllegalArgumentException("This hospital already exists in the database");
        } else {
            hospitalDataAccessService.insertHospital(hospital);
        }
    }

    public Hospital getHospital(Long hospitalID) {
        return hospitalDataAccessService.selectAllHospitals()
                .stream()
                .filter(doctor -> doctor.getHospitalID().equals(hospitalID))
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
