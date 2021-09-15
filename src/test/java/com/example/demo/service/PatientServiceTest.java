package com.example.demo.service;


import com.example.demo.patient.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.LONG;

import org.junit.jupiter.api.Assertions.*;
import org.mockito.internal.matchers.Null;

import java.time.LocalDate;
import java.util.List;

class PatientServiceTest {
    @Mock
    private PatientDataAccessServicePostgres patientDataAccessServicePostgres;
    private PatientService underTest;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new PatientService (patientDataAccessServicePostgres);
    }

    @Test
    void CanGetPatient() {

    }

    @Test
    void CanAddNewPatient() {
        // Given
        Patient Bianca = new Patient();
        Bianca.setId(12L);
        Bianca.setFirstName("Bianca");

        // When
        Mockito.when(patientDataAccessServicePostgres.insertPatient(Mockito.any(Patient.class)))
                .thenReturn(1);

        underTest.addNewPatient(Bianca);
        //Then

        ArgumentCaptor<Patient> patientArgumentCaptor = ArgumentCaptor.forClass(Patient.class);
        Mockito.verify(patientDataAccessServicePostgres).insertPatient(patientArgumentCaptor.capture());

        Patient patient = patientArgumentCaptor.getValue();
        assertThat(patient.getId()).isEqualTo(12L);
        assertThat(patient.getFirstName()).isEqualTo("Bianca");
    }

    @Test
    void willNotAddPatientWhenFirstNameIsEmpty() {
        // Given
        String firstName = " ";

        // When
        assertThatThrownBy(() -> {
            underTest.(firstName);
        }).hasMessage("First Name was empty");

        // Then
        Mockito.verifyNoInteractions(patientDataAccessServicePostgres);
    }

//    @Test
//    void CanDeletePatient() {
//        //Given
//        //When
//        //Then
//    }

    @Test
    void testGetPatient() {

                // Given
                List<Patient> cars = List.of(
                        new Patient(1L, "Isabella","Smith", LocalDate.of(1980,05 , 20),41, SEX.F, SMOKER.NO,"Lung Disease",2,LocalDate.of(03,30,2020),LocalDate.of(05,30,2020), COVIDRISK.High, ASSESSMENTRISK.High);

                Mockito.when(patientDataAccessServicePostgres.selectAllPatientsPatients()).thenReturn(Patients);

                // When
                List<Patient> allPatients = underTest.getPatient();

                // Then
                assertThat(allPatients).isEqualTo(Patients);

    }

//    @Test
//    void CanUpdatePatient() {
//        //Given
//        //When
//        //Then
//    }
}