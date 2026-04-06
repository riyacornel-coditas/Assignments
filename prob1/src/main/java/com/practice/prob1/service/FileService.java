package com.practice.prob1.service;

import com.practice.prob1.dto.FileUpload;
import com.practice.prob1.entity.File;
import com.practice.prob1.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    public File uploadFile(FileUpload fileUpload)
    {
        File file = new File();
        file.setFileName(fileUpload.getFileName());
        file.setSize(fileUpload.getSize());

        if(!file.getFileName().endsWith(".pdf"))
        {
            throw new RuntimeException("invalid file type");
        }

        if(file.getSize() > 50)
        {
            throw new RuntimeException("File size cannot be greater than 50 MB");
        }

        return fileRepository.save(file);
    }
}
