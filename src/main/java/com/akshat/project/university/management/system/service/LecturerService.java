package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.model.Lecturer;
import com.akshat.project.university.management.system.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {
    @Autowired
    private final LecturerRepository lecturerRepository;

    public LecturerService(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    public List<Lecturer> getAllLecturers() {
        List<Lecturer> lecturers = lecturerRepository.findAll();
        lecturers.sort((o1, o2) -> {
            if (o1.getFirstName() == null || o2.getFirstName() == null) {
                return 0;
            }
            return o1.getFirstName().compareTo(o2.getFirstName());
        });
        return lecturers;
    }

    public List<Lecturer> getLecturerByDepartmentId(Long departmentId) {
        return lecturerRepository.findByDepartmentId(departmentId);
    }

    public Lecturer getLecturerById(Long id) {
        return lecturerRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Error: Lecturer not found for id: " + id));
    }

    public Lecturer createLecturer(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    public Lecturer updateLecturer(Long id, Lecturer lecturerDetails) {
        Lecturer lecturer = lecturerRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Error: Lecturer not found for id: " + id));
        lecturer.setFirstName(lecturerDetails.getFirstName());
        lecturer.setMiddleName(lecturerDetails.getMiddleName());
        lecturer.setLastName(lecturerDetails.getLastName());
        lecturer.setEmail(lecturerDetails.getEmail());
        lecturer.setPhoneNumber(lecturerDetails.getPhoneNumber());
        lecturer.setGender(lecturerDetails.getGender());
        lecturer.setAddressId(lecturerDetails.getAddressId());
        lecturer.setDateOfBirth(lecturerDetails.getDateOfBirth());
        lecturer.setProfilePictureURL(lecturerDetails.getProfilePictureURL());
        lecturer.setDepartmentId(lecturerDetails.getDepartmentId());
        lecturer.setEmployeeId(lecturerDetails.getEmployeeId());
        return lecturerRepository.save(lecturer);
    }

    public Lecturer deleteLecturer(Long id) {
        Lecturer lecturer = lecturerRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Error: Lecturer not found for id: " + id));
        lecturerRepository.delete(lecturer);
        return lecturer;
    }

}
