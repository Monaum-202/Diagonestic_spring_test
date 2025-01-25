package com.example.diagnostic_test.service;


import com.example.diagnostic_test.dto.prescription.PrescriptionRequestDTO;
import com.example.diagnostic_test.entity.Doctors;
import com.example.diagnostic_test.entity.Prescription.Prescription;
import com.example.diagnostic_test.entity.Prescription.PrescriptionMedicine;
import com.example.diagnostic_test.repository.DoctorsRepository;
import com.example.diagnostic_test.repository.medicineRepo.MedicineRepository;
import com.example.diagnostic_test.repository.prescriptionRepo.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private DoctorsRepository doctorsRepository;

    public Prescription createPrescription(PrescriptionRequestDTO request) {
        Prescription prescription = new Prescription();
        Doctors doctor = doctorsRepository.findById(request.getDoctors())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        prescription.setDoctors(doctor);
        prescription.setPatientName(request.getPatientName());
        prescription.setCreatedAt(LocalDateTime.now());

        List<PrescriptionMedicine> prescriptionMedicines = request.getMedicines().stream().map(med -> {
            PrescriptionMedicine pm = new PrescriptionMedicine();
            pm.setMedicine(medicineRepository.findById(med.getId()).orElseThrow());
            pm.setDosage(med.getDosage());
            pm.setFrequency(med.getFrequency());
            pm.setPrescription(prescription);
            return pm;
        }).collect(Collectors.toList());

        prescription.setMedicines(prescriptionMedicines);
        return prescriptionRepository.save(prescription);
    }
}
