package com.akshat.project.university.management.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_id",
            sequenceName = "address_id",
            allocationSize = 1)
    @GeneratedValue(generator = "address_id", strategy = GenerationType.AUTO)
    private Long id;
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String country;
    private String pincode;
}
