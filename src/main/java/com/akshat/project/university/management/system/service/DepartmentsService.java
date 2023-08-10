package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.error.ApiRequestException;
import com.akshat.project.university.management.system.model.Department;
import com.akshat.project.university.management.system.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DepartmentsService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        try {
            return departmentRepository.findAll();
        } catch (Exception e) {
            throw new ApiRequestException("Could not fetch departments from the database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(
                () -> new ApiRequestException("Department with id: " + id + " does not exist", HttpStatus.NOT_FOUND)
        );
    }

    public Department updateDepartment(Long id, Department updatedDepartment) {
        Department department = departmentRepository.findById(id).orElseThrow();
        department.setName(updatedDepartment.getName());
        department.setAbbreviation(updatedDepartment.getAbbreviation());
        department.setDescription(updatedDepartment.getDescription());
        department.setHodId(updatedDepartment.getHodId());
        department.setImagePath(updatedDepartment.getImagePath());
        department.setImageId(updatedDepartment.getImageId());
        try {
            return departmentRepository.save(department);
        } catch (Exception e) {
            throw new ApiRequestException("Could not update department with id: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Department createDepartment(Department department) {
        if(departmentRepository.existsByName(department.getName())){
            throw new ApiRequestException("Department with name: " + department.getName() + " already exist", HttpStatus.BAD_REQUEST);
        }
        try {
            return departmentRepository.save(department);
        } catch (Exception e) {
            throw new ApiRequestException("Could not create department", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Department deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new ApiRequestException("Department with id: " + id + " does not exist", HttpStatus.NOT_FOUND)
        );
        try {
            departmentRepository.deleteById(id);
        } catch (Exception e) {
            throw new ApiRequestException("Could not delete department with id: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return department;
    }
}
