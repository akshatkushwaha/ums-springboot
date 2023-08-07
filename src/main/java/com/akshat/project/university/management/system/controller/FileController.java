package com.akshat.project.university.management.system.controller;

import com.akshat.project.university.management.system.model.File;
import com.akshat.project.university.management.system.service.FileService;
import lombok.AllArgsConstructor;
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
    private final FileService fileService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<File> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        return ResponseEntity.ok(fileService.uploadFile(multipartFile));
    }

    @GetMapping
    public ResponseEntity<java.util.List<File>> getAllFiles() {
        return ResponseEntity.ok(fileService.getAllFiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<File> getFileById(@PathVariable Long id) {
        return ResponseEntity.ok(fileService.getFileById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<File> getFileByName(@PathVariable String name) {
        return ResponseEntity.ok(fileService.getFileByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<File> deleteFile(@PathVariable Long id) {
        return ResponseEntity.ok(fileService.deleteFile(id));
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<java.io.File> downloadFile(@PathVariable Long id) {
        return ResponseEntity.ok(fileService.downloadFile(id));
    }
}
