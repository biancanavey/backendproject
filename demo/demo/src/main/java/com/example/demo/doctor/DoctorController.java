package com.example.demo.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/doctors")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> listDoctors() {
        return doctorService.getDoctors();
    }

    // TODO: add delete mapping and get doctor by name mapping

    @PostMapping
    public void addDoctor(@RequestBody Doctor doctor) {
        System.out.println(doctor);
        doctorService.addNewDoctor(doctor);
    }

    @PutMapping
    public void updateDoctor(@RequestBody Doctor doctor) {
        doctorService.updateDoctor(doctor);
    }
}
