package com.akshat.project.university.management.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {
    @Id
    @SequenceGenerator(
            name = "department_id",
            sequenceName = "department_id",
            allocationSize = 1)
    @GeneratedValue(generator = "department_id", strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true)
    private String abbreviation;
    @Column(unique = true)
    private Long hodId;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String imagePath;
}
