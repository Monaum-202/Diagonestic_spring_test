package com.example.diagnostic_test.entity.diagonesticEntry;

import com.example.diagnostic_test.entity.DiagonesticTest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class DiagnoTests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnore
    private DiagonesticTest diagonesticTest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiagonesticTest getDiagonesticTest() {
        return diagonesticTest;
    }

    public void setDiagonesticTest(DiagonesticTest diagonesticTest) {
        this.diagonesticTest = diagonesticTest;
    }
}
