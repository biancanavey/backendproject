package com.example.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.demo.ward.Ward;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Repository

public class WardDataAccessService  {

    public static List<Ward> selectAllWardsWards;
    private JdbcTemplate jdbcTemplate;

    public WardDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static List<Ward> getSelectAllWardsWards() {
        return null;
    }

    public int insertPatient(Ward ward) {
        String insertSql = """
        INSERT INTO Patient(Ward Name, Ward Id) VALUES(?, ?)
        """;
        int result = jdbcTemplate.update(ward.getWardName(), ward.getwardId());
        return result;
    }

    public void deletePatient(Ward ward) {

    }
}




// Using an Array List
//public class WardDataAccessService {

    // private Ward ward;

    //public WardDataAccessService(Ward ward) {
    //    this.ward = ward;
    //}

    // private static List<Ward> Warddb;
    //   private JdbcTemplate jdbcTemplate;

    //public WardDataAccessService() {
    //   Ward oncologyward = new Ward (1, "Oncology");
    //   Warddb = new ArrayList<>();
    //   Warddb.add(oncologyward);
    //}

    //    public List<Ward> selectAllWards() {
    //        return Warddb;
    //    }

    //    public void insertWard(Ward ward) {
    //        Warddb.add(ward);
    //   }

    //    public void deleteWard(Ward ward) {
    //        Warddb.remove(ward);
    //   }


