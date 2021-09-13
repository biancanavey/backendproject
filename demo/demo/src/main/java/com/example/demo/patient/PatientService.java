package com.example.demo.patient;

import com.example.demo.exception.PatientNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientDataAccessService patientDataAccessService;

    public PatientService(PatientDataAccessService patientDataAccessService) {
        this.patientDataAccessService = patientDataAccessService;
    }

    public List<Patient> getPatients() {
        return patientDataAccessService.selectAllPatients();
    }

    public void addNewPatient(Patient patient) {
        if (patientDataAccessService.selectAllPatients().contains(patient)) {
            throw new IllegalArgumentException("This patient already exists in the database");
        } else {
            patientDataAccessService.insertNewPatient(patient);
        }
    }

    public Patient getPatient(Long id) {
        return patientDataAccessService.selectAllPatients()
                .stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new PatientNotFoundException("Patient ID " + id + " not found"));
    }

    public void deletePatient(Long id) {
        boolean patientExists = false;
        for (Patient patient : patientDataAccessService.selectAllPatients()) {
            if (patient.getId().equals(id)) {
                patientExists = true;
                patientDataAccessService.deletePatient(patient);
            }
        }
        if (!patientExists) {
            throw new PatientNotFoundException("Patient ID " + id + " not found");
        }
    }

    public void updatePatient(Patient patient) {
        boolean patientExists = false;
        for (Patient patientInDB : patientDataAccessService.selectAllPatients()) {
            if (patientInDB.getId().equals(patient.getId())) {
                patientExists = true;
                patientInDB.setFirstName(patient.getFirstName());
                patientInDB.setLastName(patient.getLastName());
                patientInDB.setSex(patient.getSex());
                patientInDB.setDob(patient.getDob());
                patientInDB.setAge(patient.getAge());
                patientInDB.setSmoker(patient.getSmoker());
                patientInDB.setIllness(patient.getIllness());
                patientInDB.setWard(patient.getWard());
                patientInDB.setDateAdmission(patient.getDateAdmission());
                patientInDB.setDateRelease(patient.getDateRelease());
                patientInDB.setCovidrisk(patient.getCovidrisk());
                patientInDB.setAssessmentrisk(patient.getAssessmentrisk());
            }
        }
        if (!patientExists) {
            throw new PatientNotFoundException("Patient not found");
        }
    }

}
