package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.model.Department;
import com.akshat.project.university.management.system.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DepartmentsService {
    @Autowired
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow();
    }
    public Department updateDepartment(Long id, Department updatedDepartment) {
        Department department = departmentRepository.findById(id).orElseThrow();
        department.setName(updatedDepartment.getName());
        department.setAbbreviation(updatedDepartment.getAbbreviation());
        department.setDescription(updatedDepartment.getDescription());
        department.setHodId(updatedDepartment.getHodId());
        department.setImageId(updatedDepartment.getImageId());
        return departmentRepository.save(department);
    }
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
    public Department deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow();
        departmentRepository.deleteById(id);
        return department;
    }
}
