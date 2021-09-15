package com.example.demo.doctor;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class DoctorDataAccessService implements DoctorDAO {

    private static List<Doctor> doctorDatabase;

    public DoctorDataAccessService() {
        Doctor bobSmith = new Doctor(1L, "Bob", "Smith", "Cardiology", 1L);

        doctorDatabase = new ArrayList<>();
        doctorDatabase.add(bobSmith);
    }

    public List<Doctor> selectAllDoctors() {
        return doctorDatabase;
    }

    public int insertDoctor(Doctor doctor) {
        if (doctorDatabase.contains(doctor)) {
            return 0;
        } else {
            doctorDatabase.add(doctor);
            return 1;
        }
    }

    public void deleteDoctor(Doctor doctor) {
        doctorDatabase.remove(doctor);
    }
}
