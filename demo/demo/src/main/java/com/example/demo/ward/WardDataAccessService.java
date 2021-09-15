package com.example.demo.ward;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class WardDataAccessService {

    private static List<Ward> Warddb;

    public WardDataAccessService() {
        Ward oncologyWard = new Ward (1, "Oncology", 1L);
        Warddb = new ArrayList<>();
        Warddb.add(oncologyWard);
    }

    public List<Ward> selectAllWards() {
        return Warddb;
    }

    public void insertWard(Ward ward) {
        Warddb.add(ward);
    }

    public void deleteWard(Ward ward) {
        Warddb.remove(ward);
    }

}
