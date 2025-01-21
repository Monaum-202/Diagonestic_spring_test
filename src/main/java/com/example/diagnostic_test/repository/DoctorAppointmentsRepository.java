package com.example.diagnostic_test.repository;

import com.example.diagnostic_test.entity.DoctorAppointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorAppointmentsRepository extends JpaRepository<DoctorAppointments,Long> {
}
