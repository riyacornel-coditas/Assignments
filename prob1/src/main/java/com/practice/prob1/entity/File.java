package com.practice.prob1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class File {

    @Id
    @GeneratedValue
    private Long id;

    private String fileName;

    private int size;
}
