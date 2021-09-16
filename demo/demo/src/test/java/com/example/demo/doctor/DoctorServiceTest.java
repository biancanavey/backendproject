package com.example.demo.doctor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorServiceTest {

    @Mock
    private DoctorDataAccessServicePG doctorDataAccessService;
    private DoctorService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new DoctorService (doctorDataAccessService);
    }

    @Test
    void addDoctor() {
        // Given
        Doctor Joe = new Doctor();
        Joe.setDoctorID(12L);

        // When
        Mockito.when(doctorDataAccessService.insertDoctor(Mockito.any(Doctor.class)))
                .thenReturn(1);

        underTest.addNewDoctor(Joe);
        //Then

        ArgumentCaptor<Doctor> doctorArgumentCaptor = ArgumentCaptor.forClass(Doctor.class);
        Mockito.verify(doctorDataAccessService).insertDoctor(doctorArgumentCaptor.capture());

        Doctor doctor = doctorArgumentCaptor.getValue();
        assertThat(doctor.getDoctorID()).isEqualTo(12L);
    }

}
