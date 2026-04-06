package com.practice.prob1.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class FileUpload {

    private String fileName;
    private int size;
}
