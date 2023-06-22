package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.model.Department;
import com.akshat.project.university.management.system.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsService {
    @Autowired
    private final DepartmentRepository departmentRepository;

    public DepartmentsService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        departments.sort((o1, o2) -> {
            if (o1.getName() == null || o2.getName() == null) {
                return 0;
            }
            return o1.getName().compareTo(o2.getName());
        });
        return departments;
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public Department updateDepartment(Long id, Department departmentDetails) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        department.setName(departmentDetails.getName());
        department.setAbbreviation(departmentDetails.getAbbreviation());
        department.setHodId(departmentDetails.getHodId());
        department.setDescription(departmentDetails.getDescription());
        return departmentRepository.save(department);
    }

    public Department deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        departmentRepository.deleteById(id);
        return department;
    }
}
