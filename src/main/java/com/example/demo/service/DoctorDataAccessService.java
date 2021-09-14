package com.example.demo.service;
import com.example.demo.doctor.Doctor;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

    @Repository
    public class DoctorDataAccessService  {

        public static List<Doctor> selectAllDoctorsDoctors;
        private JdbcTemplate jdbcTemplate;

        public DoctorDataAccessService (JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        public static List<Doctor> selectAllDoctors() {
            return null;
        }

        public int insertDoctor(Doctor doctor) {
            String insertSql = """
        INSERT INTO Doctor(Doctor Id, First Name, Last Name, Speciality) VALUES(?, ?)
        """;
            int result = jdbcTemplate.update(insertSql,doctor.getDoctorID(),doctor.getFirstName(),doctor.getLastName(), doctor.getSpeciality());
            return result;
        }

        public void deleteDoctor(Doctor doctor) {

        }
    }

// Using an Array List
    // public class DoctorDataAccessService {

//      private static List<Doctor> doctorDatabase;
//
//   public DoctorDataAccessService() {
//       Doctor bobSmith = new Doctor(1L, "Bob", "Smith", "Cardiology");
//
//   doctorDatabase = new ArrayList<>();
//    doctorDatabase.add(bobSmith);
//       }
//
//   public List<Doctor> selectAllDoctors() {
//   return doctorDatabase;
//   }
//
//
//                         public void insertDoctor(Doctor doctor) {
//                         doctorDatabase.add(doctor);
//  }
//
//                      public void deleteDoctor(Doctor doctor) {
//                        doctorDatabase.remove(doctor);
//                      }
//}

