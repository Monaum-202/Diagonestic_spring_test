package com.example.diagnostic_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorsDTO {

    private Long doctorId;  // Unique identifier for each doctor

    private String name;  // Doctor's name

    private String gender;  // Doctor's gender

    private String departmentName;  // Name of the department the doctor belongs to

    private String contactNumber;  // Doctor's contact number

    private String email;  // Doctor's email

    private String qualification;  // Doctor's educational qualification

    private String specialty;  // Doctor's specialty

    private String scheduleTime;  // Doctor's available schedule time
}
