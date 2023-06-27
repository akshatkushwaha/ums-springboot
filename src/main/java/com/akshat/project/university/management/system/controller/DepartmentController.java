package com.akshat.project.university.management.system.controller;

import com.akshat.project.university.management.system.model.Department;
import com.akshat.project.university.management.system.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    @Autowired
    private final DepartmentsService departmentsService;

    public DepartmentController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentsService.createDepartment(department));
    }

}
