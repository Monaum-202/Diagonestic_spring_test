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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public ResponseEntity<String> createAppointment(
            @Valid @RequestBody DoctorAppointmentsDTO doctorAppointmentsDTO,
            BindingResult bindingResult) {

        // Validate the DTO
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Validation failed: " + bindingResult.getAllErrors());
        }

        try {
            // Create the appointment using the service
            DoctorAppointments appointment = doctorAppointmentService.createAppointment(doctorAppointmentsDTO);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Appointment created successfully with ID: " + appointment.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }
}




