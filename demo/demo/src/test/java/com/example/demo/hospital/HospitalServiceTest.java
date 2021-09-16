package com.example.demo.hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HospitalServiceTest {

    @Mock
    private HospitalDataAccessServicePG hospitalDataAccessServicePG;
    private HospitalService underTest;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new HospitalService(hospitalDataAccessServicePG);
    }

    @Test
    void getHospitalByID() {

        // Given
        Hospital hospital = new Hospital(1L, "Daisy Hill", "Bank Street", "Newry", "Down", "UK", "BT35 8DR");
        List<Hospital> hospitals = List.of(hospital);

        Mockito.when(hospitalDataAccessServicePG.selectAllHospitals()).thenReturn(hospitals);

        // When
        Hospital myHospital = underTest.getHospital(1L);

        // Then
        assertThat(myHospital).isEqualTo(hospital);

    }
    @Test
    void willNotAddHospitalWhenHospitalNameIsEmpty() {
        // Given
        Hospital hospital = new Hospital();
        hospital.setHospitalName(" ");

        // When
        assertThatThrownBy(() -> {
            underTest.addNewHospital(hospital);
        }).hasMessage("Error - please try again. Make sure all information entered is correct.");

    }

    @Test
    void CanAddNewHospital() {
        // Given
        Hospital Royal = new Hospital();
        Royal.setHospitalID(6L);
        Royal.setHospitalName("Royal");

        // When
        Mockito.when(hospitalDataAccessServicePG.insertHospital(Mockito.any(Hospital.class)))
                .thenReturn(1);

        underTest.addNewHospital(Royal);
        //Then

        ArgumentCaptor<Hospital> hospitalArgumentCaptor = ArgumentCaptor.forClass(Hospital.class);
        Mockito.verify(hospitalDataAccessServicePG).insertHospital(hospitalArgumentCaptor.capture());

        Hospital hospital= hospitalArgumentCaptor.getValue();
        assertThat(hospital.getHospitalID()).isEqualTo(6L);
        assertThat(hospital.getHospitalName()).isEqualTo("Royal");
    }



}
