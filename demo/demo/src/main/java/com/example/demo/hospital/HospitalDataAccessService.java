package com.example.demo.hospital;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class HospitalDataAccessService {

    private static List<Hospital> hospitalDatabase;

    public HospitalDataAccessService() {
        Hospital holbyCity = new Hospital(1L, "Holby City", "Eldon Avenue", "Borehamwood", "Hertfordshire", "UK", "WD6 1NL");
        hospitalDatabase = new ArrayList<>();
        hospitalDatabase.add(holbyCity);
    }

    public List<Hospital> selectAllHospitals() {
        return hospitalDatabase;
    }

    public void insertHospital(Hospital hospital) {
        hospitalDatabase.add(hospital);
    }

    public void deleteHospital(Hospital hospital) {
        hospitalDatabase.remove(hospital);
    }
}

