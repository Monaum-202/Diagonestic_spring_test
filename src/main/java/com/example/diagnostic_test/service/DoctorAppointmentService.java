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


    public DoctorAppointments createAppointment(DoctorAppointmentsDTO appointmentDTO) {
        // Convert DTO to Entity (if necessary)
        DoctorAppointments appointment = new DoctorAppointments();
        appointment.setPatientName(appointmentDTO.getPatientName());
        appointment.setContactNumber(appointmentDTO.getContactNumber());
        appointment.setEmail(appointmentDTO.getEmail());
        appointment.setAddress(appointmentDTO.getAddress());
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setMessage(appointmentDTO.getMessage());


//        Department department = Department.mapToEntity(appointmentDTO.getDepartment());
//        Doctors doctors = Doctors.mapToEntity(appointmentDTO.getDoctors(), department);
        Department department = departmentRepository.findById(appointmentDTO.getDepartment())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Doctors doctors = doctorsRepository.findById(appointmentDTO.getDoctors())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        appointment.setDoctors(doctors);
        appointment.setDepartment(department);

        // Save appointment to the database
        return doctorAppointmentsRepository.save(appointment);
    }
}

