package com.practice.prob1.repository;

import com.practice.prob1.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {

    File findByFileName(String fileName);
}
