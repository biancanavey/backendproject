package com.example.demo.patient;

import java.util.List;

public interface PatientDAO {

    List<Patient> selectAllPatients();
    int insertPatient(Patient patient);
    void deletePatient(Patient patient);

}
