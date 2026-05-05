package com.project.first.repository;

import com.project.first.entity.Assignment;
import com.project.first.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    Optional<Assignment> findByCourse(Course c);
}
