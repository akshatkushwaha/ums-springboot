package com.akshat.project.university.management.system.controller;

import com.akshat.project.university.management.system.model.Lecturer;
import com.akshat.project.university.management.system.service.LecturerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/lecturer")
public class LecturerController {
    @Autowired
    private final LecturerService lecturerService;

    @GetMapping
    public ResponseEntity<Iterable<Lecturer>> getAllLecturers() {
        return ResponseEntity.ok(lecturerService.getAllLecturers());
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Iterable<Lecturer>> getAllLecturersByDepartmentId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(lecturerService.getAllLecturersByDepartmentId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lecturer> getLecturerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(lecturerService.getLecturerById(id));
    }

    @PostMapping
    public ResponseEntity<Lecturer> createLecturer(@RequestBody Lecturer lecturer) {
        return ResponseEntity.ok(lecturerService.createLecturer(lecturer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lecturer> updateLecturer(@PathVariable("id") Long id, @RequestBody Lecturer lecturer) {
        return ResponseEntity.ok(lecturerService.updateLecturer(id, lecturer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lecturer> deleteLecturer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(lecturerService.deleteLecturer(id));
    }
}
