package com.project.first.service;

import com.project.first.entity.Company;
import com.project.first.entity.Course;
import com.project.first.entity.Employee;
import com.project.first.entity.Enrollment;
import com.project.first.enums.EnrollmentStatus;
import com.project.first.enums.Status;
import com.project.first.repository.CompanyRepository;
import com.project.first.repository.CourseRepository;
import com.project.first.repository.EmployeeRepository;
import com.project.first.repository.EnrollmentRepository;
import com.project.first.requestdto.EmployeeDto;
import com.project.first.requestdto.EnrollmentDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final CourseRepository courseRepository;
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final EnrollmentRepository enrollmentRepository;

    public void enrollIntoCourse(EnrollmentDto enrollmentDto) {

        Course c = courseRepository.findByTitle(enrollmentDto.getTitle())
                .orElseThrow(()-> new EntityNotFoundException("Course not found"));

        Company company = companyRepository.findByName(enrollmentDto.getName())
                .orElseThrow(()-> new EntityNotFoundException("Company not found"));

        Employee e = employeeRepository.findById(enrollmentDto.getEmployeeId())
                .orElseThrow(()-> new EntityNotFoundException("Employee not found"));


        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(c);
        enrollment.setEmployee(e);
        enrollment.setStatus(EnrollmentStatus.IN_PROGRESS);
        enrollment.setAttempt_count(enrollment.getAttempt_count()+1);

        enrollmentRepository.save(enrollment);

    }
}
