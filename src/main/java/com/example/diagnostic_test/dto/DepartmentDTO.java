package com.example.diagnostic_test.dto;

import com.example.diagnostic_test.entity.Doctors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long id;  // Department's unique identifier

    private String name;  // Name of the department

    private String description;  // Description of the department

    private List<Doctors> doctorNames;  // List of doctors' names in the department

    private List<Doctors> appointmentDates;  // List of appointment dates associated with the department
}
