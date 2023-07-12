package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.error.ApiRequestException;
import com.akshat.project.university.management.system.model.Subject;
import com.akshat.project.university.management.system.repository.StudentCreditMappingRepository;
import com.akshat.project.university.management.system.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SubjectService {
    @Autowired
    private final SubjectRepository subjectRepository;
    private final StudentCreditMappingRepository studentCreditMappingRepository;

    public Iterable<Subject> getAllSubjects() {
        try {
            return subjectRepository.findAll();
        } catch (Exception e) {
            throw new ApiRequestException("Could not fetch subjects from database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Subject> getAllSubjectsByDepartmentId(Long departmentId) {
        try {
            return subjectRepository.findAllByDepartmentId(departmentId);
        } catch (Exception e) {
            throw new ApiRequestException("Could not fetch subjects from database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Iterable<Subject> getAllSubjectsByStudentId(Long studentId) {
        try {
            Iterable<Long> subjectIds = studentCreditMappingRepository.findAllByStudentId(studentId);
            return subjectRepository.findAllById(subjectIds);
        } catch (Exception e) {
            throw new ApiRequestException("Could not fetch subjects from database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElseThrow(() -> new ApiRequestException("Subject with id: " + id + " does not exist", HttpStatus.NOT_FOUND));
    }

    public Subject updateSubject(Long id, Subject updatedSubject) {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new ApiRequestException("Subject with id: " + id + " does not exist", HttpStatus.NOT_FOUND));
        subject.setName(updatedSubject.getName());
        subject.setDepartmentId(updatedSubject.getDepartmentId());
        subject.setSubjectCode(updatedSubject.getSubjectCode());
        subject.setCredits(updatedSubject.getCredits());
        subject.setDescription(updatedSubject.getDescription());
        try {
            return subjectRepository.save(subject);
        } catch (Exception e) {
            throw new ApiRequestException("Could not update subject", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Subject createSubject(Subject subject) {
        if (subjectRepository.existsByName(subject.getName())) {
            throw new ApiRequestException("Subject with name: " + subject.getName() + " already exist", HttpStatus.BAD_REQUEST);
        }
        try {
            return subjectRepository.save(subject);
        } catch (Exception e) {
            throw new ApiRequestException("Could not create subject", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Subject deleteSubject(Long id) {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new ApiRequestException("Subject with id: " + id + " does not exist", HttpStatus.NOT_FOUND));
        try {
            subjectRepository.deleteById(id);
            return subject;
        } catch (Exception e) {
            throw new ApiRequestException("Could not delete subject", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
