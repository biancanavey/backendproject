package com.example.demo.service;
import com.example.demo.patient.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
    public class PatientDataAccessServicePostgres  {

    public static List<Patient> selectAllPatientsPatients;
    private JdbcTemplate jdbcTemplate;

        public PatientDataAccessServicePostgres(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        public static List<Patient> selectAllPatientsPatients() {
            return null;
        }

        public int insertPatient(Patient patient) {
            String insertSql = """
        INSERT INTO Patient(movie_name, release_date) VALUES(?, ?)
        """;
            int result = jdbcTemplate.update(insertSql, patient.getId(), patient.getFirstName(),patient.getLastName(), patient.getDob(),patient.getAge(),patient.getSEX(),patient.getSMOKER(),patient.getIllness(),patient.getWard(),patient.getDateAdmission(),patient.getDateRelease(),patient.getCOVIDRISK(),patient.getASSESSMENTRISK());
            return result;
        }

        public void deletePatient(Patient patient) {

        }
}

