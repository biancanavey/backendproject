package com.example.demo.doctor;

import com.example.demo.exception.DoctorNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private DoctorDataAccessServicePG doctorDataAccessService;

    public DoctorService(DoctorDataAccessServicePG doctorDataAccessService) {
        this.doctorDataAccessService = doctorDataAccessService;
    }

    public List<Doctor> getDoctors() {
        return doctorDataAccessService.selectAllDoctors();
    }

    public void addNewDoctor(Doctor doctor) {
        int result = doctorDataAccessService.insertDoctor(doctor);
        if (result != 1) {
            throw new IllegalStateException("Error - please try again. Make sure all information entered is correct.");
        }
    }

    public Doctor getDoctor(Long doctorID) {
        return doctorDataAccessService.selectAllDoctors()
                .stream()
                .filter(doctor -> doctor.getDoctorID().equals(doctorID))
                .findFirst()
                .orElseThrow(() -> new DoctorNotFoundException("Doctor ID " + doctorID + " not found"));
    }

    public void deleteDoctor(Long doctorID) {
        boolean doctorExists = false;
        for (Doctor doctor : doctorDataAccessService.selectAllDoctors()) {
            if (doctor.getDoctorID().equals(doctorID)) {
                doctorExists = true;
                doctorDataAccessService.deleteDoctor(doctor);
            }
        }
        if (!doctorExists) {
            throw new DoctorNotFoundException("Doctor ID " + doctorID + " not found");
        }
    }

    public void updateDoctor(Doctor doctor) {
        boolean doctorExists = false;
        for (Doctor doctorInDB : doctorDataAccessService.selectAllDoctors()) {
            if (doctorInDB.getDoctorID().equals(doctor.getDoctorID())) {
                doctorExists = true;
                doctorInDB.setSpeciality(doctor.getSpeciality());
                doctorInDB.setFirstName(doctor.getFirstName());
                doctorInDB.setLastName(doctor.getLastName());
                doctorInDB.setHospital(doctor.getHospital());
            }
        }
        if (!doctorExists) {
            throw new DoctorNotFoundException("Doctor not found");
        }
    }
}
