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
        try {
            String contentType = multipartFile.getContentType();
            String fileName = UUID.randomUUID().toString();
            String directoryPath = System.getProperty("user.dir") + "/uploads";
            String filePath = directoryPath + "/" + fileName + "." + contentType.split("/")[1];
            java.io.File directory = new java.io.File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            multipartFile.transferTo(new java.io.File(filePath));

            File file = new File();
            file.setName(fileName);
            file.setContentType(contentType);
            file.setPath(filePath);

            return fileRepository.save(file);
        } catch (IOException e) {
            // Log the exception for detailed error analysis
            e.printStackTrace();
            throw new ApiRequestException("Could not transfer file", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            // Log the exception for detailed error analysis
            e.printStackTrace();
            throw new ApiRequestException("Could not upload file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public byte[] downloadFile(String name) {
        File file = fileRepository.findByName(name).orElseThrow(() -> new ApiRequestException("File not found", HttpStatus.NOT_FOUND));
        try {
            java.io.File fileToDownload = new java.io.File(file.getPath());
            return java.nio.file.Files.readAllBytes(fileToDownload.toPath());
        } catch (Exception e) {
            // Log the exception for detailed error analysis
            e.printStackTrace();
            throw new ApiRequestException("Could not download file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public byte[] downloadFileByPath(String path) {
        File file = fileRepository.findByPath(path).orElseThrow(() -> new ApiRequestException("File not found", HttpStatus.NOT_FOUND));
        try {
            java.io.File fileToDownload = new java.io.File(file.getPath());
            return java.nio.file.Files.readAllBytes(fileToDownload.toPath());
        } catch (Exception e) {
            // Log the exception for detailed error analysis
            e.printStackTrace();
            throw new ApiRequestException("Could not download file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public  byte[] downloadFileById(Long id) {
        File file = fileRepository.findById(id).orElseThrow(() -> new ApiRequestException("File not found", HttpStatus.NOT_FOUND));
        try {
            java.io.File fileToDownload = new java.io.File(file.getPath());
            return java.nio.file.Files.readAllBytes(fileToDownload.toPath());
        } catch (Exception e) {
            // Log the exception for detailed error analysis
            e.printStackTrace();
            throw new ApiRequestException("Could not download file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public File getFileById(Long id) {
        return fileRepository.findById(id).orElseThrow(() -> new ApiRequestException("File not found", HttpStatus.NOT_FOUND));
    }

    public File deleteFileById(Long id) {
        File file = fileRepository.findById(id).orElseThrow(() -> new ApiRequestException("File not found", HttpStatus.NOT_FOUND));
        try {
            java.io.File fileToDelete = new java.io.File(file.getPath());
            boolean deleted = fileToDelete.delete();
            if (!deleted) {
                throw new ApiRequestException("Could not delete file", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            fileRepository.deleteById(id);
        } catch (Exception e) {
            // Log the exception for detailed error analysis
            e.printStackTrace();
            throw new ApiRequestException("Could not delete file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return file;
    }
}
