package com.akshat.project.university.management.system.repository;

import com.akshat.project.university.management.system.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
    List<Lecturer> findByDepartmentId(Long departmentId);
}
