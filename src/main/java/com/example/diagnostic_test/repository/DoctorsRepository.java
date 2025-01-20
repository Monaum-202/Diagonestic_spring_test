package com.example.diagnostic_test.repository;

import com.example.diagnostic_test.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorsRepository extends JpaRepository<Doctors,Long> {

//    List<Doctors> findByDepartment(Long department_id);
}
