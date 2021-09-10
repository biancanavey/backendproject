package com.example.demo.doctor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private DoctorDataAccessService doctorDataAccessService;

    public DoctorService(DoctorDataAccessService doctorDataAccessService) {
        this.doctorDataAccessService = doctorDataAccessService;
    }

    public List<Doctor> getDoctors() {
        return doctorDataAccessService.selectAllDoctors();
    }

    public void addNewDoctor(Doctor doctor) {
        // TODO: add exceptions below
        if (doctorDataAccessService.selectAllDoctors().contains(doctor)) {
            System.out.println("This movie already exists!");
        } else {
            doctorDataAccessService.insertDoctor(doctor);
        }
    }

    public void deleteDoctor(String firstName, String lastName) {
        boolean doctorExists = false;
        for (Doctor doctor : doctorDataAccessService.selectAllDoctors()) {
            if (doctor.getFirstName().equals(firstName) && doctor.getLastName().equals(lastName)) {
                doctorExists = true;
                doctorDataAccessService.deleteDoctor(doctor);
            }
        }
        if (!doctorExists) {
            System.out.println("This doctor does not exist in the database!");
        }
    }

    public void updateDoctor(Doctor doctor) {
        boolean doctorExists = false;
        for (Doctor doctorInDB : doctorDataAccessService.selectAllDoctors()) {
            if (doctorInDB.getFirstName().equals(doctor.getFirstName()) && doctorInDB.getFirstName().equals(doctor.getFirstName())) {
                doctorExists = true;
                doctorInDB.setSpeciality(doctor.getSpeciality());
            }
        }
        if (!doctorExists) {
            System.out.println("This doctor does not exist in the database!");
        }
    }
}
