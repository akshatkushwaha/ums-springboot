package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.error.ApiRequestException;
import com.akshat.project.university.management.system.model.Student;
import com.akshat.project.university.management.system.repository.StudentCreditMappingRepository;
import com.akshat.project.university.management.system.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    private final StudentCreditMappingRepository studentCreditMappingRepository;

    public List<Student> getAllStudents() {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            throw new ApiRequestException("Could not fetch students from database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Student> getAllStudentsByDepartmentId(Long departmentId) {
        try {
            return studentRepository.findAllByDepartmentId(departmentId);
        } catch (Exception e) {
            throw new ApiRequestException("Could not fetch students from database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Iterable<Student> getAllStudentsBySubjectId(Long subjectId) {
        try {
            List<Long> studentIds = studentCreditMappingRepository.findAllBySubjectId(subjectId);
            return studentRepository.findAllById(studentIds);
        } catch (Exception e) {
            throw new ApiRequestException("Could not fetch students from database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ApiRequestException("Student with id: " + id + " does not exist", HttpStatus.NOT_FOUND));
    }

    public Student createStudent(Student student) {
        try {
            return studentRepository.save(student);
        } catch (Exception e) {
            throw new ApiRequestException("Could not create student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ApiRequestException("Student with id: " + id + " does not exist", HttpStatus.NOT_FOUND));
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
        try {
            return studentRepository.save(student);
        } catch (Exception e) {
            throw new ApiRequestException("Could not update student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Student deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ApiRequestException("Student with id: " + id + " does not exist", HttpStatus.NOT_FOUND));
        try {
            studentRepository.delete(student);
            return student;
        } catch (Exception e) {
            throw new ApiRequestException("Could not update student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
