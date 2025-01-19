package com.example.diagnostic_test.controller;

import com.example.diagnostic_test.entity.Department;
import com.example.diagnostic_test.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/department")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;



    @GetMapping
    public List<Department> getAllUsers() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department getUserById(@PathVariable long id) {
        Optional<Department> user = departmentRepository.findById(id);
        return user.orElse(null);  // Return the user if found, otherwise return null
    }

    @PostMapping("/post")
    public Department createUser(@RequestBody Department department) {
        return departmentRepository.save(department);  // Save the user to the database
    }

    @PutMapping("/{id}")
    public Department updateUser(@PathVariable long id, @RequestBody Department department) {
        if (departmentRepository.existsById(id)) {
            department.setId(id);
            return departmentRepository.save(department);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return "User deleted successfully.";
        }
        return "User not found.";
    }
}
