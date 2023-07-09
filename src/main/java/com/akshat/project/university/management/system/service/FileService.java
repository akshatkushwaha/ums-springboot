package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.model.File;
import com.akshat.project.university.management.system.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@Service
public class FileService {
    @Autowired
    private final FileRepository fileRepository;

    public File getFileById(Long id){
        return fileRepository.findById(id).orElseThrow(() -> new IllegalStateException("File not found"));
    }

    public File getFileByName(String name){
        return fileRepository.findByName(name).orElseThrow(() -> new IllegalStateException("File not found"));
    }

    public File createFile(MultipartFile file) throws IOException {
        System.out.println(file);
        File newFile = new File();
        newFile.setName(file.getName());
        newFile.setContentType(file.getContentType());
        newFile.setSize(file.getSize());
        newFile.setData(file.getBytes());

        return fileRepository.save(newFile);
    }

    public File deteleFile(Long id){
        File file = fileRepository.findById(id).orElseThrow(() -> new IllegalStateException("File not found"));
        fileRepository.delete(file);
        return file;
    }
}
