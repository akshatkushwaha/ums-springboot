package com.akshat.project.university.management.system.repository;

import com.akshat.project.university.management.system.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    boolean existsByName(String name);

    List<Subject> findAllByDepartmentId(Long departmentId);
}
