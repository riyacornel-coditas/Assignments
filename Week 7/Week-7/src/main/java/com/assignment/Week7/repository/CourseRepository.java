package com.assignment.Week7.repository;

import com.assignment.Week7.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
