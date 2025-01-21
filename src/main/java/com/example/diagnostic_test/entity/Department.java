package com.example.diagnostic_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;



    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    private List<Doctors> doctors;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    private List<DoctorAppointments> appointments;






    // Default constructor
    public Department() {}

    // Parameterized constructor
    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Doctors> getDoctors() {
        return doctors;
    }


    public void setDoctors(List<Doctors> doctors) {
        this.doctors = doctors;
    }

    public List<DoctorAppointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<DoctorAppointments> appointments) {
        this.appointments = appointments;
    }

    //
//    @Override
//    public String toString() {
//        return "Department{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
}

