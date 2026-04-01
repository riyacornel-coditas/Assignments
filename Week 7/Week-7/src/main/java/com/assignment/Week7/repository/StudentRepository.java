package com.assignment.Week7.repository;

import com.assignment.Week7.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
