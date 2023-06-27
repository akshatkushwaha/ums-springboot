package com.akshat.project.university.management.system.repository;

import com.akshat.project.university.management.system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByDepartmentId(Long departmentId);
}
