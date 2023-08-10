package com.akshat.project.university.management.system.controller;

import com.akshat.project.university.management.system.model.Student;
import com.akshat.project.university.management.system.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<Iterable<Student>> getAllStudents(
            @RequestParam(name = "departmentId", required = false) Long departmentId,
            @RequestParam(name = "subjectId", required = false) Long subjectId
    ) {
        if (departmentId != null) {
            return ResponseEntity.ok(studentService.getAllStudentsByDepartmentId(departmentId));
        }
        if (subjectId != null) {
            return ResponseEntity.ok(studentService.getAllStudentsBySubjectId(subjectId));
        }
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

//    @GetMapping("/department/{id}")
//    public ResponseEntity<Iterable<Student>> getAllStudentsByDepartmentId(@PathVariable("id") Long departmentId) {
//        return ResponseEntity.ok(studentService.getAllStudentsByDepartmentId(departmentId));
//    }
//
//    @GetMapping("/subject/{id}")
//    public ResponseEntity<Iterable<Student>> getAllStudentsBySubjectId(@PathVariable("id") Long subjectId){
//        return ResponseEntity.ok(studentService.getAllStudentsBySubjectId(subjectId));
//    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Long id = student.getId();
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id) {
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }
}
