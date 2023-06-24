package com.akshat.project.university.management.system.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentCreditMapping {
    private Long studentId;
    private Long subjectId;
    private Integer credits;
    private Integer semester;
    private Boolean isCompleted;
}
