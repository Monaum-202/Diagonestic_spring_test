package com.example.diagnostic_test.controller;

import com.example.diagnostic_test.entity.Doctors;
import com.example.diagnostic_test.entity.Medicine.Medicine;
import com.example.diagnostic_test.repository.medicineRepo.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/api/medicines")
public class MedicineController {
    @Autowired
    private MedicineRepository medicineRepository;

    @GetMapping
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    @PostMapping
    public Medicine createUser(@RequestBody Medicine medicine) {
        return medicineRepository.save(medicine);  // Save the user to the database
    }

    @GetMapping("/{id}")
    public Medicine getUserById(@PathVariable long id) {
        Optional<Medicine> user = medicineRepository.findById(id);
        return user.orElse(null);  // Return the user if found, otherwise return null
    }


    @PutMapping("/{id}")
    public Medicine updateUser(@PathVariable long id, @RequestBody Medicine medicine) {
        if (medicineRepository.existsById(id)) {
            medicine.setId(id);
            return medicineRepository.save(medicine);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        if (medicineRepository.existsById(id)) {
            medicineRepository.deleteById(id);
            return "User deleted successfully.";
        }
        return "User not found.";
    }

}
