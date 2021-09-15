package com.example.demo.doctor;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class DoctorDataAccessService {

    private static List<Doctor> doctorDatabase;

    public DoctorDataAccessService() {
        Doctor bobSmith = new Doctor(1L, "Bob", "Smith", "Cardiology", 1L);

        doctorDatabase = new ArrayList<>();
        doctorDatabase.add(bobSmith);
    }

    public List<Doctor> selectAllDoctors() {
        return doctorDatabase;
    }

    public void insertDoctor(Doctor doctor) {
        doctorDatabase.add(doctor);
    }

    public void deleteDoctor(Doctor doctor) {
        doctorDatabase.remove(doctor);
    }
}
