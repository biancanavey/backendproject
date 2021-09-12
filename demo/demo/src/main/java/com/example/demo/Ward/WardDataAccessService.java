package com.example.demo.Ward;

//Missing import?
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WardDataAccessService {

    private static List<Ward> Warddb;

    public WardDataAccessService() {
        Ward oncologyward = new Ward ("Oncology", 1)
        Warddb = new ArrayList<>();
        Warddb.add(oncologyward);

    public List<Ward> selectAllWard() {
        return Warddb;
    }

    public void insertWard(Ward ward) {
        Warddb.add(ward);
    }

    public void deleteWard(Ward ward) {
        Warddb.remove(ward);
    }

}