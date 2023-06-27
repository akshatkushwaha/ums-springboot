package com.akshat.project.university.management.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subject {
    @Id
    @SequenceGenerator(
            name = "subject_id",
            sequenceName = "subject_id",
            allocationSize = 1)
    @GeneratedValue(generator = "subject_id", strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    private Long departmentId;
    @Column(unique = true)
    private String subjectCode;
    private Integer credits;
    private String description;
}
