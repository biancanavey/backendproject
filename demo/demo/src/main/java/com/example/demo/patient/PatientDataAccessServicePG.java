package com.example.demo.patient;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository

public class PatientDataAccessServicePG {

    private JdbcTemplate jdbcTemplate;

    public PatientDataAccessServicePG (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Patient> selectAllPatients() {
        String selectSql = """
                SELECT * FROM patient
                """;
        return jdbcTemplate.query(selectSql, new BeanPropertyRowMapper(Patient.class));
    }

    public int insertPatient(Patient patient) {
        String insertSql = """
        INSERT INTO patient(id, first_name, last_name, sex, dob, age, smoker, illness, ward, date_admission, date_release, covid_risk, assessment_risk) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;
        int result = jdbcTemplate.update(insertSql, patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getSex(), patient.getDob(), patient.getAge(), patient.getSmoker(), patient.getIllness(), patient.getWard(), patient.getDateAdmission(), patient.getDateRelease(), patient.getCovidrisk(), patient.getAssessmentrisk());
        return result;
    }

    public void deletePatient(Patient patient) {
        String deleteSql = """
                DELETE FROM patient WHERE id = ?
                """;
        jdbcTemplate.update(deleteSql, patient.getId());
    }

}
