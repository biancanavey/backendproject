package com.example.demo.patient;
import java.time.LocalDate;

public class Patient {
    private Long Id;
    private String firstName;
    private String lastName;
    private SEX SEX;
    private LocalDate dob;
    private Integer age;
    private SMOKER SMOKER;
    private String illness;
    private Integer ward;
    private LocalDate dateAdmission;
    private LocalDate dateRelease;
    private COVIDRISK COVIDRISK;
    private ASSESSMENTRISK ASSESSMENTRISK;


    public Patient() {
    }

    public Patient(String firstName,
                   String lastName,
                   LocalDate dob,
                   Integer age,
                   SEX SEX,
                   SMOKER SMOKER,
                   String illness,
                   Integer ward,
                   LocalDate dateAdmission,
                   LocalDate dateRelease,
                   COVIDRISK COVIDRISK,
                   ASSESSMENTRISK ASSESSMENTRISK
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

    public SMOKER getSMOKER() {
        return SMOKER;
    }

    public void setSMOKER(SMOKER SMOKER) {
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

    public COVIDRISK getCOVIDRISK() {
        return COVIDRISK;
    }

    public void setCOVIDRISK(COVIDRISK COVIDRISK) {
        this.COVIDRISK = COVIDRISK;
    }

    public ASSESSMENTRISK getASSESSMENTRISK() {
        return ASSESSMENTRISK;
    }

    public void setASSESSMENTRISK(ASSESSMENTRISK ASSESSMENTRISK) {
        this.ASSESSMENTRISK = ASSESSMENTRISK;
    }

    public SEX getSEX() {
        return SEX;
    }

    public void setSEX(SEX SEX) {
        this.SEX = SEX;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", SEX=" + SEX +
                ", dob=" + dob +
                ", age=" + age +
                ", SMOKER=" + SMOKER +
                ", illness='" + illness + '\'' +
                ", ward=" + ward +
                ", dateAdmission=" + dateAdmission +
                ", dateRelease=" + dateRelease +
                ", COVIDRISK=" + COVIDRISK +
                ", ASSESSMENTRISK=" + ASSESSMENTRISK +
                '}';
    }

}

