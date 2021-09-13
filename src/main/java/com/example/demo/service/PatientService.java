package com.example.demo.service;

import com.example.demo.patient.Patient;
import com.example.demo.exceptions.PatientNotFoundException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PatientService  {

//    private PatientDataAccessService patientDataAccessService;
    private PatientDataAccessServicePostgres patientDataAccessServicePostgres;
    private Object Patient;


    public PatientService(PatientDataAccessServicePostgres patientDataAccessServicePostgres) {
        this.patientDataAccessServicePostgres = patientDataAccessServicePostgres;

    }

    public List<com.example.demo.patient.Patient> getPatient() {
        return patientDataAccessServicePostgres.selectAllPatientsPatients();
    }

    public void addNewPatient(Patient patient) {
        //  check if patient exists
        int result = patientDataAccessServicePostgres.insertPatient(patient);
        if (result != 1) {
            throw new IllegalStateException("Error please try again. Make sure all information entered is correct");
        }
    }

    public void deletePatient(Long Id) {
        List<Patient> patients = patientDataAccessServicePostgres.selectAllPatientsPatients();
        boolean found = false;
        for (Patient patient : patients) {
            if (patient.getId().equals(Id)) {
                found = true;
                patientDataAccessServicePostgres.deletePatient(patient);
            }
        }
        if (!found) {
            throw new PatientNotFoundException(Id + " not found");
        }
    }

    public Patient getPatient(Long patientID) {
        return patientDataAccessServicePostgres.selectAllPatientsPatients()
                .stream()
                .filter(patient -> patient.getId().equals(patientID))
                .findFirst()
                .orElseThrow(() -> new PatientNotFoundException(patientID + " not found"));
    }

    private boolean doesPatientExists(Long Id) {
        return PatientDataAccessServicePostgres.selectAllPatientsPatients()
                .stream()
                .anyMatch(patient -> patient.getId().equals(patient.getId()));
    }

    public void updatePatient(Patient patient) {
        List<Patient> patients = PatientDataAccessServicePostgres.selectAllPatientsPatients;
        boolean found = false;
        for (Patient p : patients) {
            if (p.getId().equals(patient.getId())) {
                found = true;
                p.setWard(patient.getWard());
                p.setDateAdmission(patient.getDateAdmission());
                p.setDateRelease(patient.getDateRelease());
            }
        }
        if (!found) {
            throw new PatientNotFoundException(patient.getId() + " not found");
        }
    }
}