package com.practice.prob1.controller;

import com.practice.prob1.dto.FileUpload;
import com.practice.prob1.entity.File;
import com.practice.prob1.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload")
    public File uploadFile(@RequestBody FileUpload fileUpload)
    {
        return fileService.uploadFile(fileUpload);
    }
}
