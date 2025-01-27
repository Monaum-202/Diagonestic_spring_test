package com.example.diagnostic_test.controller;

import com.example.diagnostic_test.dto.diagnosticReceipt.DiagnosticMoneyReciptDTo;
import com.example.diagnostic_test.dto.prescription.PrescriptionRequestDTO;
import com.example.diagnostic_test.entity.Prescription.Prescription;
import com.example.diagnostic_test.entity.diagonesticEntry.DiagnosticMoneyReceipt;
import com.example.diagnostic_test.service.DiagnosticMoneyReceiptService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/api/MoneyReceipt")
public class DiagnosticMoneyReciptController {


    @Autowired
    private DiagnosticMoneyReceiptService diagnosticMoneyReceiptService;
    @PostMapping
    public ResponseEntity<DiagnosticMoneyReceipt> createPrescription(@Valid @RequestBody DiagnosticMoneyReciptDTo request) {
        return ResponseEntity.ok(diagnosticMoneyReceiptService.createDiagnosticMoneyReceipt(request));
    }
}
