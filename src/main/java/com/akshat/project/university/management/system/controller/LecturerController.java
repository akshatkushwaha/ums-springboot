package com.akshat.project.university.management.system.controller;

import com.akshat.project.university.management.system.model.Lecturer;
import com.akshat.project.university.management.system.service.LecturerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/lecturer")
public class LecturerController {
    private final LecturerService lecturerService;

    @GetMapping
    public ResponseEntity<Iterable<Lecturer>> getAllLecturers(@RequestParam(name = "departmentId", required = false) Long departmentId) {
        if (departmentId != null) {
            return ResponseEntity.ok(lecturerService.getAllLecturersByDepartmentId(departmentId));
        }
        return ResponseEntity.ok(lecturerService.getAllLecturers());
    }

//    @GetMapping("/department/{id}")
//    public ResponseEntity<Iterable<Lecturer>> getAllLecturersByDepartmentId(@PathVariable("id") Long id) {
//        return ResponseEntity.ok(lecturerService.getAllLecturersByDepartmentId(id));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Lecturer> getLecturerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(lecturerService.getLecturerById(id));
    }

    @PostMapping
    public ResponseEntity<Lecturer> createLecturer(@RequestBody Lecturer lecturer) {
        return ResponseEntity.ok(lecturerService.createLecturer(lecturer));
    }

    @PutMapping
    public ResponseEntity<Lecturer> updateLecturer(@RequestBody Lecturer lecturer) {
        Long id = lecturer.getId();
        return ResponseEntity.ok(lecturerService.updateLecturer(id, lecturer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lecturer> deleteLecturer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(lecturerService.deleteLecturer(id));
    }
}
