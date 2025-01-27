package com.example.diagnostic_test.repository;

import com.example.diagnostic_test.entity.diagonesticEntry.DiagnosticMoneyReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticMoneyReceiptRepository extends JpaRepository<DiagnosticMoneyReceipt,Long> {
}
