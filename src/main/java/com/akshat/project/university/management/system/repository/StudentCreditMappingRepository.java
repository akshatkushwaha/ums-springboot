package com.akshat.project.university.management.system.repository;

import com.akshat.project.university.management.system.model.StudentCreditMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCreditMappingRepository extends JpaRepository<StudentCreditMapping, Long> {
    List<Long> findAllBySubjectId(Long subjectId);
    List<Long> findAllByStudentId(Long studentId);
}
