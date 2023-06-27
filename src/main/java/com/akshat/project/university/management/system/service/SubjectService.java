package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.model.Subject;
import com.akshat.project.university.management.system.repository.StudentCreditMappingRepository;
import com.akshat.project.university.management.system.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SubjectService {
    @Autowired
    private final SubjectRepository subjectRepository;
    @Autowired
    private final StudentCreditMappingRepository studentCreditMappingRepository;

    public Iterable<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public List<Subject> getAllSubjectsByDepartmentId(Long departmentId) {
        return subjectRepository.findAllByDepartmentId(departmentId);
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElseThrow();
    }

    public Iterable<Subject> getAllSubjectsByStudentId(Long studentId){
        Iterable<Long> subjectIds = studentCreditMappingRepository.findAllByStudentId(studentId);
        return subjectRepository.findAllById(subjectIds);
    }

    public Subject updateSubject(Long id, Subject updatedSubject){
        Subject subject = subjectRepository.findById(id).orElseThrow();
        subject.setName(updatedSubject.getName());
        subject.setDepartmentId(updatedSubject.getDepartmentId());
        subject.setSubjectCode(updatedSubject.getSubjectCode());
        subject.setCredits(updatedSubject.getCredits());
        subject.setDescription(updatedSubject.getDescription());
        return subjectRepository.save(subject);
    }

    public Subject createSubject(Subject subject) {
        if(subjectRepository.existsByName(subject.getName())) {
            throw new IllegalStateException("Subject already exists!");
        }
        return subjectRepository.save(subject);
    }

    public Subject deleteSubject(Long id) {
        Subject subject = subjectRepository.findById(id).orElseThrow();
        subjectRepository.deleteById(id);
        return subject;
    }
}
