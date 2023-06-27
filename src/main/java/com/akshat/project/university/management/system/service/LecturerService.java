package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.model.Lecturer;
import com.akshat.project.university.management.system.repository.LecturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LecturerService {
    @Autowired
    private final LecturerRepository lecturerRepository;

    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    public List<Lecturer> getAllLecturerByDepartmentId(Long departmentId) {
        return lecturerRepository.findAllByDepartmentId(departmentId);
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
