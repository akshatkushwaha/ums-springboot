package com.akshat.project.university.management.system.repository;

import com.akshat.project.university.management.system.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Long> {
    Optional<File> findByName(String name);
}
