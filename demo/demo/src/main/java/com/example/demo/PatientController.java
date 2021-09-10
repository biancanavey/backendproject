package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "api/patient")
public class PatientController {

    // TODO: Implement update patient

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> listPatients() {
        return patientService.getPatient();
    }

    // i.e localhost:8080/api/patient
    @GetMapping("{patientName}")
    public Patient getPatientByName(@PathVariable("patientName") String patientName) {
        /*
            TODO: Find and return superHeroName in db if not present throw new PatientNotFoundException("message");
            Note that business logic should be in MovieService
         */
        return (Patient) patientService.getPatient();
    }


    @PostMapping
    public void addMovie(@RequestBody Patient patient) {
        System.out.println(patient);
        patientService.addNewPatient(patient);
    }

    // i.e DELETE localhost:8080/api/patient/james
    @DeleteMapping("{patientName}")
    public void deletePatient(@PathVariable("patientName") String patientName) {
        // TODO: Implement delete patient
        patientService.deletePatient(patientName);
    }

    @PutMapping
    public void updatePatient(@RequestBody Patient patient) {
        patientService.updatePatient(patient);
    }

}
