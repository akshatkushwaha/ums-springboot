package com.akshat.project.university.management.system.repository;

import com.akshat.project.university.management.system.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
