package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.error.ApiRequestException;
import com.akshat.project.university.management.system.model.File;
import com.akshat.project.university.management.system.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class FileService {
    private final FileRepository fileRepository;

    public File uploadFile(MultipartFile multipartFile) {
        String contentType = multipartFile.getContentType();
        String fileName = UUID.randomUUID().toString();
        System.out.println(fileName);
        System.out.println(System.getProperty("user.dir") + "\\src\\main\\resources\\uploads\\" + multipartFile.getOriginalFilename());
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\uploads\\" + fileName + "." + contentType.split("/")[1];
        System.out.println(path);
        try {
            multipartFile.transferTo(new java.io.File(path));
        } catch (IOException e) {
            throw new ApiRequestException("Could not transfer file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        File file = new File();
        file.setName(fileName);
        file.setContentType(contentType);
        file.setPath(path);
        try {
            return fileRepository.save(file);
        } catch (Exception e) {
            throw new ApiRequestException("Could not upload file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public File getFileById(Long id) {
        return fileRepository.findById(id).orElseThrow(
                () -> new ApiRequestException("File with id: " + id + " does not exist", HttpStatus.NOT_FOUND)
        );
    }

    public File getFileByName(String name) {
        return fileRepository.findByName(name).orElseThrow(
                () -> new ApiRequestException("File with name: " + name + " does not exist", HttpStatus.NOT_FOUND)
        );
    }

    public File deleteFile(Long id) {
        File file = fileRepository.findById(id).orElseThrow(
                () -> new ApiRequestException("File with id: " + id + " does not exist", HttpStatus.NOT_FOUND)
        );
        try {
            java.io.File fileToDelete = new java.io.File(file.getPath());
            boolean delete = fileToDelete.delete();
            if (!delete) {
                throw new ApiRequestException("Could not delete file with id: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            fileRepository.delete(file);
            return file;
        } catch (Exception e) {
            throw new ApiRequestException("Could not delete file with id: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public java.io.File downloadFile(Long id) {
        File file = fileRepository.findById(id).orElseThrow(
                () -> new ApiRequestException("File with id: " + id + " does not exist", HttpStatus.NOT_FOUND)
        );
        return new java.io.File(file.getPath());
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }
}
