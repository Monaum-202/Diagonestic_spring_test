package com.example.diagnostic_test.service;

import com.example.diagnostic_test.dto.DoctorAppointmentsDTO;
import com.example.diagnostic_test.entity.Department;
import com.example.diagnostic_test.entity.DoctorAppointments;
import com.example.diagnostic_test.entity.Doctors;
import com.example.diagnostic_test.repository.DepartmentRepository;
import com.example.diagnostic_test.repository.DoctorAppointmentsRepository;
import com.example.diagnostic_test.repository.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DoctorAppointmentService {

@Autowired
    private final DoctorAppointmentsRepository doctorAppointmentsRepository;

@Autowired
    private final DoctorsRepository doctorsRepository;

@Autowired
    private final DepartmentRepository departmentRepository;


    public DoctorAppointmentService(DoctorAppointmentsRepository doctorAppointmentsRepository,
                              DoctorsRepository doctorsRepository,
                              DepartmentRepository departmentRepository) {
        this.doctorAppointmentsRepository = doctorAppointmentsRepository;
        this.doctorsRepository = doctorsRepository;
        this.departmentRepository = departmentRepository;
    }


    public DoctorAppointments createAppointment(DoctorAppointmentsDTO dto) {
        Doctors doctors = doctorsRepository.findById(Long.parseLong(dto.getDoctor()))
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        Department department = departmentRepository.findById(Long.parseLong(dto.getDepartment()))
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));

        DoctorAppointments appointment = new DoctorAppointments();
        appointment.setPatientName(dto.getName());
        appointment.setPhoneNumber(dto.getPhone());
        appointment.setEmail(dto.getEmail());
        appointment.setAppointmentDate(dto.getDate());
        appointment.setMessage(dto.getMessage());
        appointment.setDoctors(doctors);
        appointment.setDepartment(department);

        return doctorAppointmentsRepository.save(appointment);
    }
}

