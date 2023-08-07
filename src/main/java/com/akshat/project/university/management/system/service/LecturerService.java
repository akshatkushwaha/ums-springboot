package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.error.ApiRequestException;
import com.akshat.project.university.management.system.model.Lecturer;
import com.akshat.project.university.management.system.repository.LecturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LecturerService {
    @Autowired
    private final LecturerRepository lecturerRepository;

    public List<Lecturer> getAllLecturers() {
        try {
            return lecturerRepository.findAll();
        } catch (Exception e) {
            throw new ApiRequestException("Could not fetch lecturers from database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Lecturer> getAllLecturersByDepartmentId(Long departmentId) {
        try {
            return lecturerRepository.findAllByDepartmentId(departmentId);
        } catch (Exception e) {
            throw new ApiRequestException("Could not fetch lecturers from database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Lecturer getLecturerById(Long id) {
        return lecturerRepository.findById(id).orElseThrow(() -> new ApiRequestException("Lecturer with id: " + id + " does not exist", HttpStatus.NOT_FOUND));
    }

    public Lecturer createLecturer(Lecturer lecturer) {
        try {
            return lecturerRepository.save(lecturer);
        } catch (Exception e) {
            throw new ApiRequestException("Could not create lecturer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Lecturer updateLecturer(Long id, Lecturer lecturerDetails) {
        Lecturer lecturer = lecturerRepository.findById(id).orElseThrow(() -> new ApiRequestException("Lecturer with id: " + id + " does not exist", HttpStatus.NOT_FOUND));
        lecturer.setFirstName(lecturerDetails.getFirstName());
        lecturer.setMiddleName(lecturerDetails.getMiddleName());
        lecturer.setLastName(lecturerDetails.getLastName());
        lecturer.setEmail(lecturerDetails.getEmail());
        lecturer.setPhoneNumber(lecturerDetails.getPhoneNumber());
        lecturer.setGender(lecturerDetails.getGender());
        lecturer.setAddressId(lecturerDetails.getAddressId());
        lecturer.setDateOfBirth(lecturerDetails.getDateOfBirth());
        lecturer.setProfilePicturePath(lecturerDetails.getProfilePicturePath());
        lecturer.setDepartmentId(lecturerDetails.getDepartmentId());
        lecturer.setEmployeeId(lecturerDetails.getEmployeeId());
        try {
            return lecturerRepository.save(lecturer);
        } catch (Exception e) {
            throw new ApiRequestException("Could not update lecturer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Lecturer deleteLecturer(Long id) {
        Lecturer lecturer = lecturerRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: Lecturer not found for id: " + id));
        try{
            lecturerRepository.delete(lecturer);
        } catch (Exception e) {
            throw new ApiRequestException("Could not delete lecturer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return lecturer;
    }
}
