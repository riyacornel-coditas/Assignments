package com.project.first.repository;

import com.project.first.entity.Course;
import com.project.first.entity.Employee;
import com.project.first.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    boolean existsByEmployeeAndCourse(Employee e, Course c);
    Optional<Enrollment> findByEmployeeAndCourse(Employee e, Course c);
    List<Enrollment> findByEmployee(Employee e);
}
