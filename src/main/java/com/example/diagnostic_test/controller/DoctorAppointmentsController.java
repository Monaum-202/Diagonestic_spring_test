package com.example.diagnostic_test.controller;

import com.example.diagnostic_test.entity.Department;
import com.example.diagnostic_test.entity.DoctorAppointments;
import com.example.diagnostic_test.entity.Doctors;
import com.example.diagnostic_test.repository.DepartmentRepository;
import com.example.diagnostic_test.repository.DoctorAppointmentsRepository;
import com.example.diagnostic_test.repository.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/api/doctorAppointments")
public class DoctorAppointmentsController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DoctorsRepository doctorRepository;

    @Autowired
    private DoctorAppointmentsRepository doctorAppointmentsRepository;
    // Get all departments
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get doctors by department
    @GetMapping("/doctors/by-department/{departmentId}")
    public List<Doctors> getDoctorsByDepartment(@PathVariable Long departmentId) {

        return departmentRepository.getById(departmentId).getDoctors();
    }

    @PostMapping
    public DoctorAppointments addAppointment(@RequestBody DoctorAppointments doctorAppointments){
            return doctorAppointmentsRepository.save(doctorAppointments);  // Save the user to the database
        }
    }

