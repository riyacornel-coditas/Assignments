package com.project.first.repository;

import com.project.first.entity.Course;
import com.project.first.entity.Employee;
import com.project.first.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {


    List<Enrollment> findByEmployeeIdIn(List<Long> employeeIds);

    Optional<Enrollment> findByEmployeeIdAndCourseId(Long id, Long id1);

    boolean existsByEmployeeIdAndCourseId(Long employeeId, Long courseId);
}
