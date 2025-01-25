package com.example.diagnostic_test.entity.Medicine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineId;
    @ManyToOne
    @JoinColumn(name = "generic_id")
    @JsonIgnore
    private MedicineGeneric generic;
    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private MedicineCompany company;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private MedicineCategory category;
    private String medicineName;
    private String form;
    private String strength;
    private Double price;
    private String packSize;
//    private Double buyingPrice;
}
