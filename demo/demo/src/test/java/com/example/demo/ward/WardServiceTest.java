package com.example.demo.ward;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WardServiceTest {

    @Mock
    private WardDataAccessServicePG wdaspg;
    private WardService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new WardService(wdaspg);
    }

    @Test
    void addNewWard() {

        int wardId = 5;
        String wardName = "Oncology";
        Long hospital = 1L;

        Ward ward = new Ward(wardId, wardName, hospital);

        Mockito.when(wdaspg.insertWard(Mockito.any(Ward.class)))
                .thenReturn(1);

        underTest.addNewWard(ward);

        ArgumentCaptor<Ward> wardArgumentCaptor = ArgumentCaptor.forClass(Ward.class);
        Mockito.verify(wdaspg).insertWard(wardArgumentCaptor.capture());

        Ward newWard = wardArgumentCaptor.getValue();
        assertThat(newWard.getWardId()).isEqualTo(5);
        assertThat(newWard.getWardName()).isEqualTo("Oncology");
        assertThat(newWard.getHospital()).isEqualTo(1L);
    }


}
