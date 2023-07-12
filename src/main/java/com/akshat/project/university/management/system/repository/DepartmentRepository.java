package com.akshat.project.university.management.system.repository;

import com.akshat.project.university.management.system.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    boolean existsByName(String name);
}
