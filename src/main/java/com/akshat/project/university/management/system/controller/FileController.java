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

//    @GetMapping("/download/{name}")
//    public ResponseEntity<byte[]> downloadFile(@PathVariable String name) {
//        return ResponseEntity
//                .ok()
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(fileService.downloadFile(name));
//    }
//
//    @GetMapping("/{path}")
//    public ResponseEntity<byte[]> downloadFileByPath(@PathVariable String path) {
//        return ResponseEntity
//                .ok()
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(fileService.downloadFileByPath(path));
//    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFileById(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(fileService.downloadFileById(id));
    }

    @GetMapping
    public ResponseEntity<java.util.List<File>> getAllFiles() {
        return ResponseEntity.ok(fileService.getAllFiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<File> getFileById(@PathVariable Long id) {
        return ResponseEntity.ok(fileService.getFileById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<File> deleteFileById(@PathVariable Long id) {
        return ResponseEntity.ok(fileService.deleteFileById(id));
    }
}
