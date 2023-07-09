package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.model.Student;
import com.akshat.project.university.management.system.repository.StudentCreditMappingRepository;
import com.akshat.project.university.management.system.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    private final StudentCreditMappingRepository studentCreditMappingRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getAllStudentsByDepartmentId(Long departmentId) {
        return studentRepository.findAllByDepartmentId(departmentId);
    }

    public Iterable<Student> getAllStudentsBySubjectId(Long subjectId) {
        List<Long> studentIds = studentCreditMappingRepository.findAllBySubjectId(subjectId);
        return studentRepository.findAllById(studentIds);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Error: Student not found for id: " + id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Error: Student not found for id: " + id));
        student.setFirstName(studentDetails.getFirstName());
        student.setMiddleName(studentDetails.getMiddleName());
        student.setLastName(studentDetails.getLastName());
        student.setEmail(studentDetails.getEmail());
        student.setPhoneNumber(studentDetails.getPhoneNumber());
        student.setGender(studentDetails.getGender());
        student.setAddressId(studentDetails.getAddressId());
        student.setDateOfBirth(studentDetails.getDateOfBirth());
        student.setProfilePictureId(studentDetails.getProfilePictureId());
        student.setDepartmentId(studentDetails.getDepartmentId());
        student.setRollNumber(studentDetails.getRollNumber());
        return studentRepository.save(student);
    }

    public Student deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Error: Student not found for id: " + id));
        studentRepository.delete(student);
        return student;
    }
}
