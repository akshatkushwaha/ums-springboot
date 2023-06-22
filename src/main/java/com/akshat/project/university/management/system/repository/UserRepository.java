package com.akshat.project.university.management.system.repository;

import com.akshat.project.university.management.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
