package com.example.demo.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/hospitals")
public class HospitalController {

    private HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping
    public List<Hospital> listHospitals() {
        return hospitalService.getHospitals();
    }

    @GetMapping
    public Hospital getHospitalByID(@PathVariable("hopsitalID") Long hospitalID) {
        return hospitalService.getHospital(hospitalID);
    }

    @PostMapping
    public void addHospital(@RequestBody Hospital hospital) {
        System.out.println(hospital);
        hospitalService.addNewHospital(hospital);
    }

    @DeleteMapping
    public void deleteHospital(@PathVariable("hospitalID") Long hospitalID) {
        hospitalService.deleteHospital(hospitalID);
    }

    @PutMapping
    public void updateHospital(@RequestBody Hospital hospital) {
        hospitalService.updateHospital(hospital);
    }
}
