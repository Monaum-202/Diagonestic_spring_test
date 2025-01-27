package com.example.diagnostic_test.service;

import com.example.diagnostic_test.dto.diagnosticReceipt.DiagnosticMoneyReciptDTo;
import com.example.diagnostic_test.dto.prescription.PrescriptionRequestDTO;
import com.example.diagnostic_test.entity.Doctors;
import com.example.diagnostic_test.entity.Prescription.Prescription;
import com.example.diagnostic_test.entity.Prescription.PrescriptionMedicine;
import com.example.diagnostic_test.entity.Prescription.PrescriptionTests;
import com.example.diagnostic_test.entity.diagonesticEntry.DiagnoTests;
import com.example.diagnostic_test.entity.diagonesticEntry.DiagnosticMoneyReceipt;
import com.example.diagnostic_test.repository.DiagnosticMoneyReceiptRepository;
import com.example.diagnostic_test.repository.DiagonesticTestRepository;
import com.example.diagnostic_test.repository.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiagnosticMoneyReceiptService {

    @Autowired
    private DiagnosticMoneyReceiptRepository diagnosticMoneyReceiptRepository;

    @Autowired
    private DoctorsRepository doctorsRepository;

    @Autowired
    private DiagonesticTestRepository diagonesticTestRepository;


    public DiagnosticMoneyReceipt createDiagnosticMoneyReceipt(DiagnosticMoneyReciptDTo request) {
        DiagnosticMoneyReceipt diagnosticMoneyReceipt = new DiagnosticMoneyReceipt();
        Doctors doctor = doctorsRepository.findById(request.getRefBy())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        diagnosticMoneyReceipt.setRefBy(doctor);
        diagnosticMoneyReceipt.setPatientName(request.getPatientName());
        diagnosticMoneyReceipt.setAge(request.getAge());
        diagnosticMoneyReceipt.setSex(request.getSex());
        diagnosticMoneyReceipt.setMobile(request.getMobile());
        diagnosticMoneyReceipt.setCreatedAt(LocalDateTime.now());
        diagnosticMoneyReceipt.setTotalAmount(request.getTotalAmount());
        diagnosticMoneyReceipt.setDiscount(request.getDiscount());
        diagnosticMoneyReceipt.setPayableAmount(request.getPayableAmount());
        diagnosticMoneyReceipt.setPaidAmount(request.getPaidAmount());
        diagnosticMoneyReceipt.setDueAmount(request.getDueAmount());



        List<DiagnoTests> diagnoTests = request.getDiagonesticTests().stream().map(dts -> {
            DiagnoTests dt = new DiagnoTests();
            dt.setDiagonesticTest(diagonesticTestRepository.findById(dts.getId()).orElseThrow());
            return dt;
        }).collect(Collectors.toList());

        diagnosticMoneyReceipt.setDiagonesticTests(diagnoTests);



        return diagnosticMoneyReceiptRepository.save(diagnosticMoneyReceipt);
    }
}
