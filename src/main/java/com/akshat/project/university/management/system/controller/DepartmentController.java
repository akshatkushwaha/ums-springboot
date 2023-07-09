package com.akshat.project.university.management.system.controller;

import com.akshat.project.university.management.system.model.Department;
import com.akshat.project.university.management.system.service.DepartmentsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    @Autowired
    private final DepartmentsService departmentsService;

    @GetMapping
    public ResponseEntity<Iterable<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentsService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(departmentsService.getDepartmentById(id));
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentsService.createDepartment(department));
    }

    @PutMapping
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
        Long id = department.getId();
        return ResponseEntity.ok(departmentsService.updateDepartment(id, department));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable("id") Long id) {
        return ResponseEntity.ok(departmentsService.deleteDepartment(id));
    }
}
