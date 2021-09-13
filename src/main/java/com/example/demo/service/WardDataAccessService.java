package com.example.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.example.demo.ward.Ward;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Repository
public class WardDataAccessService {

    private  Ward ward;

    public WardDataAccessService(Ward ward) {
        this.ward = ward;
    }

    private static List<Ward> Warddb;

    public WardDataAccessService() {
        Ward oncologyward = new Ward (1, "Oncology");
        Warddb = new ArrayList<>();
        Warddb.add(oncologyward);
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
