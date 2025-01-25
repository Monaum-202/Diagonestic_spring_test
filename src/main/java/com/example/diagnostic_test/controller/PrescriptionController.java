package com.example.diagnostic_test.controller;

import com.example.diagnostic_test.dto.prescription.PrescriptionRequestDTO;
import com.example.diagnostic_test.entity.Prescription.Prescription;
import com.example.diagnostic_test.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controllers
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/api/prescriptions")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<Prescription> createPrescription(@RequestBody PrescriptionRequestDTO request) {
        return ResponseEntity.ok(prescriptionService.createPrescription(request));
    }
}
