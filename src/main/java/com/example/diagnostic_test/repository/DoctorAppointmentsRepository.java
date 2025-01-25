package com.example.diagnostic_test.repository;

import com.example.diagnostic_test.entity.DoctorAppointments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DoctorAppointmentsRepository extends JpaRepository<DoctorAppointments,Long> {


    @Query(value = "SELECT * FROM doctor_appointments WHERE doctor_id = :doc_id ", nativeQuery = true)
    List<DoctorAppointments> findAllPatientByDoctorId(@Param("doc_id") Long doctorId);
}
