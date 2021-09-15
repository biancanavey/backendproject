package com.example.demo.patient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

public class PatientServiceTest {

    @Mock
    private PatientDataAccessServicePG patientDataAccessServicePostgres;
    private PatientService underTest;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new PatientService (patientDataAccessServicePostgres);
    }

    @Test
    void testGetPatient() {

        // Given
        List<Patient> patients = List.of(
                new Patient(1L, "Isabella","Smith", SEX.F, LocalDate.of(1980, 4, 20),41, SMOKER.NO,"Lung Disease",2, LocalDate.of(2020, 3, 30),LocalDate.of(2020, 5, 30), COVIDRISK.High, ASSESSMENTRISK.High, 1L));

        Mockito.when(patientDataAccessServicePostgres.selectAllPatients()).thenReturn(patients);

        // When
        List<Patient> allPatients = underTest.getPatients();

        // Then
        assertThat(allPatients).isEqualTo(patients);

    }

}
