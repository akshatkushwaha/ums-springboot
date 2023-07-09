package com.akshat.project.university.management.system.controller;

import com.akshat.project.university.management.system.model.Subject;
import com.akshat.project.university.management.system.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {
    @Autowired
    public final SubjectService subjectService;

    @GetMapping
    public ResponseEntity<Iterable<Subject>> getAllSubjects(
            @RequestParam(name = "departmentId", required = false) Long departmentId,
            @RequestParam(name = "studentId", required = false) Long studentId
    ) {
        if (studentId != null) {
            return ResponseEntity.ok(subjectService.getAllSubjectsByStudentId(studentId));
        }
        if (departmentId != null) {
            return ResponseEntity.ok(subjectService.getAllSubjectsByDepartmentId(departmentId));
        }
        return ResponseEntity.ok(subjectService.getAllSubjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(subjectService.getSubjectById(id));
    }

//    @GetMapping("/department/{id}")
//    public ResponseEntity<Iterable<Subject>> getAllSubjectsByDepartmentId(@PathVariable("id") Long departmentId) {
//        return ResponseEntity.ok(subjectService.getAllSubjectsByDepartmentId(departmentId));
//    }
//
//    @GetMapping("/student/{id}")
//    public ResponseEntity<Iterable<Subject>> getAllSubjectsByStudentId(@PathVariable("id") Long studentId) {
//        return ResponseEntity.ok(subjectService.getAllSubjectsByStudentId(studentId));
//    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        return ResponseEntity.ok(subjectService.createSubject(subject));
    }

    @PutMapping
    public ResponseEntity<Subject> updateSubject( @RequestBody Subject subject) {
        Long id = subject.getId();
        return ResponseEntity.ok(subjectService.updateSubject(id, subject));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable("id") Long id) {
        return ResponseEntity.ok(subjectService.deleteSubject(id));
    }
}
