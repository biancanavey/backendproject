package com.example.demo.controller;

import com.example.demo.patient.Patient;
import com.example.demo.service.PatientService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "api/patient")
public class PatientController {

    // Implement update patient

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> listPatients() {
        return patientService.getPatient();
    }

    // i.e localhost:8080/api/patient
    @GetMapping("{patientId}")
    public Patient getPatientById() {
        /*
            Find and return Ward in db if not present throw new PatientNotFoundException("message");
            Note that business logic should be in MovieService
         */
        return (Patient) patientService.getPatient();
    }


    @PostMapping
    public void addPatient(@RequestBody Patient patient) {
        System.out.println(patient);
        patientService.addNewPatient(patient);
    }

    // i.e DELETE localhost:8080/api/patient/james
    @DeleteMapping("{patientId}")
    public void deletePatient(@PathVariable("patientId") Long patientId) {
        // Implement delete patient
        patientService.deletePatient(patientId);
    }

    @PutMapping
    public void updatePatient(@RequestBody Patient patient) {
        patientService.updatePatient(patient);
    }

}
