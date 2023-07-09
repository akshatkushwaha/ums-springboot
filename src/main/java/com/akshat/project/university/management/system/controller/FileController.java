package com.akshat.project.university.management.system.controller;

import com.akshat.project.university.management.system.model.File;
import com.akshat.project.university.management.system.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/file")
public class FileController {
    @Autowired
    private final FileService fileService;

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFileById(@PathVariable("id") Long id){
        File file = fileService.getFileById(id);
        return ResponseEntity.ok().contentType(MediaType.valueOf(file.getContentType())).body(file.getData());
    }

    @PostMapping
    public ResponseEntity<File> createFile(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(fileService.createFile(file));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<File> deleteFile(@PathVariable("id") Long id){
        return ResponseEntity.ok(fileService.deteleFile(id));
    }
}
