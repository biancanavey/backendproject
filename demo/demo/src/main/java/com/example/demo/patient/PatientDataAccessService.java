package com.example.demo.patient;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

@Repository
public class PatientDataAccessService {

    private static List<Patient> patientDatabase;

    public PatientDataAccessService() {
        LocalDate dob = LocalDate.of(1952, 7, 13);
        LocalDate dateAdmission = LocalDate.of(2021, 8, 17);
        LocalDate dateRelease = LocalDate.of(2021, 9, 12);
        Patient susanJones = new Patient(1L, "Susan", "Jones", SEX.F, dob, 69, SMOKER.YES, "Cancer", 7, dateAdmission, dateRelease, COVIDRISK.High, ASSESSMENTRISK.High, 1L);
        patientDatabase = new ArrayList<>();
        patientDatabase.add(susanJones);
    }

    public List<Patient> selectAllPatients() {
        return patientDatabase;
    }

    public void insertPatient(Patient patient) {
        patientDatabase.add(patient);
    }

    public void deletePatient(Patient patient) {
        patientDatabase.remove(patient);
    }
}
