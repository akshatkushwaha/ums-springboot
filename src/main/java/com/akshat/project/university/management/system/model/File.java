package com.akshat.project.university.management.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class File {
    @Id
    @SequenceGenerator(
            name = "file_id",
            sequenceName = "file_id",
            allocationSize = 1)
    @GeneratedValue(generator = "file_id", strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String contentType;
    private String path;

    public void setFile(byte[] bytes) {

    }
}
