package com.example.demo.doctor;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class DoctorDataAccessServicePG {

    private JdbcTemplate jdbcTemplate;

    public DoctorDataAccessServicePG (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Doctor> selectAllDoctors() {
        String selectSql = """
                SELECT * FROM doctor
                """;
        return jdbcTemplate.query(selectSql, new BeanPropertyRowMapper(Doctor.class));
    }

    public int insertDoctor(Doctor doctor) {
        String insertSql = """
        INSERT INTO doctor(doctor_id, first_name, last_name, speciality) VALUES(?, ?, ?, ?)
        """;
        int result = jdbcTemplate.update(insertSql, doctor.getDoctorID(), doctor.getFirstName(), doctor.getLastName(), doctor.getSpeciality());
        return result;
    }

    public void deleteDoctor(Doctor doctor) {
        String deleteSql = """
                DELETE FROM doctor WHERE doctor_id = ?
                """;
        jdbcTemplate.update(deleteSql, doctor.getDoctorID());
    }

}
