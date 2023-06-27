package com.akshat.project.university.management.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentCreditMapping {
    @Id
    @SequenceGenerator(
            name = "student_credit_mapping_sequence",
            sequenceName = "student_credit_mapping_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long studentId;
    private Long subjectId;
    private Integer credits;
    private Integer semester;
    private Boolean isCompleted;
}
