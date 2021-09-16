package com.example.demo.patient;

import com.example.demo.exception.PatientNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.doctor.DoctorService;
import com.example.demo.ward.WardService;

import com.example.demo.doctor.Doctor;
import com.example.demo.ward.Ward;

import java.util.List;

@Service
public class PatientService {

    private PatientDataAccessServicePG patientDataAccessService;

    public PatientService(PatientDataAccessServicePG patientDataAccessService) {
        this.patientDataAccessService = patientDataAccessService;
    }

    public List<Patient> getPatients() {
        return patientDataAccessService.selectAllPatients();
    }

    public void addNewPatient(Patient patient) {
        int result = patientDataAccessService.insertPatient(patient);
        if (result != 1) {
            throw new IllegalStateException("Error - please try again. Make sure all information entered is correct.");
        }
    }

    public Patient getPatient(Long id) {
        return patientDataAccessService.selectAllPatients()
                .stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new PatientNotFoundException("Patient ID " + id + " not found"));
    }

    public int deletePatient(Long id) {
        for (Patient patient : patientDataAccessService.selectAllPatients()) {
            if (patient.getId().equals(id)) {
                patientDataAccessService.deletePatient(patient);
                return 1;
            }
        }
        throw new PatientNotFoundException("Patient ID " + id + " not found");
    }

    public int updatePatient(Patient patient) {
        for (Patient patientInDB : patientDataAccessService.selectAllPatients()) {
            if (patientInDB.getId().equals(patient.getId())) {
                patientDataAccessService.deletePatient(patientInDB);
                patientDataAccessService.insertPatient(patient);
                return 1;
            }
        }
        throw new PatientNotFoundException("Patient not found");
    }

}
