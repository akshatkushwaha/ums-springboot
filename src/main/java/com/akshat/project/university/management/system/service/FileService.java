package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.error.ApiRequestException;
import com.akshat.project.university.management.system.model.File;
import com.akshat.project.university.management.system.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@Service
public class FileService {
    @Autowired
    private final FileRepository fileRepository;

    public File getFileById(Long id) {
        return fileRepository.findById(id).orElseThrow(() -> new ApiRequestException(
                "File with id: " + id + " does not exist", HttpStatus.NOT_FOUND
        ));
    }

    public File getFileByName(String name) {
        return fileRepository.findByName(name).orElseThrow(() -> new ApiRequestException(
                "File with name: " + name + " does not exist", HttpStatus.NOT_FOUND
        ));
    }

    public File createFile(MultipartFile file) throws IOException {
        System.out.println(file);
        File newFile = new File();
        newFile.setName(file.getName());
        newFile.setContentType(file.getContentType());
        newFile.setSize(file.getSize());
        newFile.setData(file.getBytes());
        try {
            return fileRepository.save(newFile);
        } catch (Exception e) {
            throw  new ApiRequestException("Could not upload file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public File deteleFile(Long id) {
        File file = fileRepository.findById(id).orElseThrow(() -> new ApiRequestException(
                "File with id: " + id + " does not exist", HttpStatus.NOT_FOUND
        ));
        try {
            fileRepository.delete(file);
        } catch (Exception e) {
            throw  new ApiRequestException("Could not delete file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return file;
    }
}
