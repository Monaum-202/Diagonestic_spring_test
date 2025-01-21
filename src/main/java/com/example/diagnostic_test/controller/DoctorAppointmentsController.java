package com.example.diagnostic_test.controller;

import com.example.diagnostic_test.dto.DoctorAppointmentsDTO;
import com.example.diagnostic_test.entity.Department;
import com.example.diagnostic_test.entity.DoctorAppointments;
import com.example.diagnostic_test.entity.Doctors;
import com.example.diagnostic_test.repository.DepartmentRepository;
import com.example.diagnostic_test.repository.DoctorAppointmentsRepository;
import com.example.diagnostic_test.repository.DoctorsRepository;
import com.example.diagnostic_test.service.DoctorAppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @Autowired
    private DoctorAppointmentService doctorAppointmentService;

    // Get all departments
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get doctors by department
    @GetMapping("/doctors/by-department/{departmentId}")
    public List<Doctors> getDoctorsByDepartment(@PathVariable Long departmentId) {
        List<Doctors> dcList = doctorRepository.findAllByDepartmentId(departmentId);
        List<Doctors> newDcList = new ArrayList<>();

        for (Doctors dc: dcList
             ) {
            dc.setDepartment(null);
            newDcList.add(dc);
        }
//        return departmentRepository.getById(departmentId).getDoctors();
        return newDcList;
    }

    @PostMapping
    public ResponseEntity<DoctorAppointments> createAppointment(@RequestBody DoctorAppointmentsDTO appointmentDTO) {
        System.out.println("hello");
        DoctorAppointments doctorAppointments = doctorAppointmentService.createAppointment(appointmentDTO);
        return ResponseEntity.ok(doctorAppointments);
    }


}

