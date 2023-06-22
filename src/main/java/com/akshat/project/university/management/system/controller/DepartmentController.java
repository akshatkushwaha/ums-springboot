package com.akshat.project.university.management.system.controller;

import com.akshat.project.university.management.system.model.Department;
import com.akshat.project.university.management.system.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    @Autowired
    private final DepartmentsService departmentsService;

    public DepartmentController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping
    public List<Department> getDepartment() {
        return departmentsService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable(value = "id") Long id) {
        return departmentsService.getDepartmentById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentsService.createDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable(value = "id") Long id, @RequestBody Department departmentDetails) {
        return departmentsService.updateDepartment(id, departmentDetails);
    }

    @DeleteMapping("/{id}")
    public Department deleteDepartment(@PathVariable(value = "id") Long id) {
        return departmentsService.deleteDepartment(id);
    }
}
