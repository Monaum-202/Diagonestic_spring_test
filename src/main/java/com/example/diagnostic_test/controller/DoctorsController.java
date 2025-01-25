package com.example.diagnostic_test.controller;

import com.example.diagnostic_test.entity.DoctorAppointments;
import com.example.diagnostic_test.repository.DoctorAppointmentsRepository;
import com.example.diagnostic_test.repository.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/api/doctor")
public class DoctorsController {


    @Autowired
    private DoctorsRepository doctorRepository;

    @Autowired
    private DoctorAppointmentsRepository doctorAppointmentsRepository;

    @GetMapping("/patients/{doctorId}")
    public List<DoctorAppointments> getPatientsByDoctor(@PathVariable Long doctorId) {
        List<DoctorAppointments> patientList = doctorAppointmentsRepository.findAllPatientByDoctorId(doctorId);
        List<DoctorAppointments> newPatientList = new ArrayList<>();

        for (DoctorAppointments dc: patientList
        ) {
            dc.setDepartment(null);
            newPatientList.add(dc);
        }
//        return departmentRepository.getById(departmentId).getDoctors();
        return newPatientList;
    }
}
