package com.example.diagnostic_test.entity;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@ToString
public class Doctors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId; // Unique identifier for each doctor

    private String name; // Doctor's first name

    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department; // Reference to the department


    private String contactNumber; // Doctor's contact number

    private String email; // Doctor's email


    private String qualification; // Educational qualifications

    private String specialty;





    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }


}
