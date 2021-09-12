package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Service
public class PatientService {
    public static List<Patient> getPatient() {
        return List.of(
                new Patient(

                )
        );
    }

//    public Patient getPatient(String patientName) {
//    }

    public void addNewPatient(Patient patient) {
    }

    public void deletePatient(String patientName) {
    }

    public void updatePatient(Patient patient) {
    }
}
