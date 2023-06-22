package com.akshat.project.university.management.system.controller;

import com.akshat.project.university.management.system.model.Lecturer;
import com.akshat.project.university.management.system.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/lecturer")
public class LecturerController {
    @Autowired
    private final LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping
    public List<Lecturer> getLecturer(@RequestParam Long departmentId) {
        if(departmentId != null)
            return lecturerService.getLecturerByDepartmentId(departmentId);
        return lecturerService.getAllLecturers();
    }

    @GetMapping("/{id}")
    public Lecturer getLecturerById(@PathVariable(value = "id") Long id) {
        return lecturerService.getLecturerById(id);
    }

    @PostMapping
    public Lecturer createLecturer(@RequestBody Lecturer lecturer) {
        return lecturerService.createLecturer(lecturer);
    }

    @PutMapping("/{id}")
    public Lecturer updateLecturer(@PathVariable(value = "id") Long id, @RequestBody Lecturer lecturerDetails) {
        return lecturerService.updateLecturer(id, lecturerDetails);
    }

    @DeleteMapping("/{id}")
    public Lecturer deleteLecturer(@PathVariable(value = "id") Long id) {
        return lecturerService.deleteLecturer(id);
    }
}
