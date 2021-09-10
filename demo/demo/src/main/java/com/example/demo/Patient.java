package com.example.demo;
import java.time.LocalDate;

public class Patient {
    private Long Id;
    private String firstName;
    private String lastName;
    Enum SEX;
    private LocalDate dob;
    private Integer age;
    Enum SMOKER;
    private String illness;
    private Integer ward;
    private LocalDate dateAdmission;
    private LocalDate dateRelease;
    Enum COVIDRISK;
    Enum ASSESSMENTRISK;


    public Patient() {
    }

    public Patient(String firstName,
                   String lastName,
                   LocalDate dob,
                   Integer age,
                   Enum SEX,
                   Enum SMOKER,
                   String illness,
                   Integer ward,
                   LocalDate dateAdmission,
                   LocalDate dateRelease,
                   Enum COVIDRISK,
                   Enum ASSESSMENTRISK
                   ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.age = age;
        this.SEX = SEX;
        this.SMOKER = SMOKER;
        this.illness = illness;
        this.ward = ward;
        this.dateAdmission = dateAdmission;
        this.dateRelease = dateRelease;
        this.COVIDRISK = COVIDRISK;
        this.ASSESSMENTRISK = ASSESSMENTRISK;
        // enums do not work
    }


    public Long getId() {
        return Id;
    }


    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Enum getSMOKER() {
        return SMOKER;
    }

    public void setSMOKER(Enum SMOKER) {
        this.SMOKER = SMOKER;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public Integer getWard() {
        return ward;
    }

    public void setWard(Integer ward) {
        this.ward = ward;
    }

    public LocalDate getDateAdmission() {
        return dateAdmission;
    }

    public void setDateAdmission(LocalDate dateAdmission) {
        this.dateAdmission = dateAdmission;
    }

    public LocalDate getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(LocalDate dateRelease) {
        this.dateRelease = dateRelease;
    }

    public Enum getCOVIDRISK() {
        return COVIDRISK;
    }

    public void setCOVIDRISK(Enum COVIDRISK) {
        this.COVIDRISK = COVIDRISK;
    }

    public Enum getASSESSMENTRISK() {
        return ASSESSMENTRISK;
    }

    public void setASSESSMENTRISK(Enum ASSESSMENTRISK) {
        this.ASSESSMENTRISK = ASSESSMENTRISK;
    }

    public Enum getSEX() {
        return SEX;
    }

    public void setSEX(Enum SEX) {
        this.SEX = SEX;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "Id=" + Id +
                ", Name='" + firstName +lastName + '\'' +
                ", DOB=" + dob +
                ", Age=" + age +
                '}';
    }
}

