package com.akshat.project.university.management.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @Id
    @SequenceGenerator(
            name = "person_id",
            sequenceName = "person_id",
            allocationSize = 1)
    @GeneratedValue(generator = "person_id", strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String gender;
    private Long addressId;
    private LocalDate dateOfBirth;
    private String profilePictureURL;
}
