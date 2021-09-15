package com.example.demo.hospital;

import java.util.List;

public interface HospitalDAO {

    List<Hospital> selectAllHospitals();
    int insertHospital(Hospital hospital);
    void deleteHospital(Hospital hospital);

}
