package com.project.first.repository;

import com.project.first.entity.Enrollment;
import com.project.first.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
