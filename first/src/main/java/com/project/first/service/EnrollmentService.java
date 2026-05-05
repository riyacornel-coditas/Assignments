package com.project.first.service;

import com.project.first.entity.Course;
import com.project.first.entity.Employee;
import com.project.first.entity.Enrollment;
import com.project.first.enums.Status;
import com.project.first.repository.CourseRepository;
import com.project.first.repository.EmployeeRepository;
import com.project.first.repository.EnrollmentRepository;
import com.project.first.requestdto.EmployeeDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final CourseRepository courseRepository;
    private final EmployeeRepository employeeRepository;

    public void enrollIntoCourse(EmployeeDto employeeDto, Long id) {

        Course c = courseRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Course not found"));

        Enrollment e = new Enrollment();
        e.setStatus();

    }
}
