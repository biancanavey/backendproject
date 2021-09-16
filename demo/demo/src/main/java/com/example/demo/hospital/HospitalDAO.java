package com.example.demo.hospital;

import java.util.List;

public interface HospitalDAO {

    List<Hospital> selectAllHospitals();
    int insertHospital(Hospital hospital);
    int deleteHospital(Hospital hospital);

}
