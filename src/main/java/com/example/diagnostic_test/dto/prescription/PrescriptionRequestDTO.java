package com.example.diagnostic_test.dto.prescription;

import java.util.List;

public class PrescriptionRequestDTO {

    private Long doctorId;
    private String patientName;
    private List<MedicineRequestDTO> medicines;

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public List<MedicineRequestDTO> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<MedicineRequestDTO> medicines) {
        this.medicines = medicines;
    }
}
