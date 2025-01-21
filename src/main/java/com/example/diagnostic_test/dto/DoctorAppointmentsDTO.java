package com.example.diagnostic_test.dto;

import com.example.diagnostic_test.entity.Department;
import com.example.diagnostic_test.entity.Doctors;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class DoctorAppointmentsDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    @Email
    private String email;

    private String address;

    @NotNull
    private LocalDate date;

    private String message;

    @NotNull
    private Doctors doctor;

    @NotNull
    private Department department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDoctor(Doctors doctor) {
        this.doctor = doctor;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Doctors getDoctor() {
        return doctor;
    }

    public Department getDepartment() {
        return department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
