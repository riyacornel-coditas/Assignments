package com.project.first.service;

import com.project.first.entity.Company;
import com.project.first.entity.Course;
import com.project.first.entity.Employee;
import com.project.first.enums.Status;
import com.project.first.repository.CompanyRepository;
import com.project.first.repository.CourseRepository;
import com.project.first.repository.EmployeeRepository;
import com.project.first.requestdto.AssignCourseDto;
import com.project.first.requestdto.CourseDto;
import com.project.first.requestdto.EmployeeDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;

    public void addCourse(CourseDto courseDto)
    {
            Course c = new Course();
            c.setTitle(courseDto.getTitle());
            c.setDuration(courseDto.getDuration());
            c.setStartDate(courseDto.getStartDate());
            c.setEndDate(courseDto.getEndDate());
            courseRepository.save(c);

    }


    public void assignCourseToCompany(AssignCourseDto assignCourseDto) {

        Course c = courseRepository.findByTitle(assignCourseDto.getTitle())
                .orElseThrow(()-> new EntityNotFoundException("Course not added!"));

        Company company = companyRepository.findByName(assignCourseDto.getName())
                .orElseThrow(()-> new EntityNotFoundException("Company not found"));

        company.setCourse(c);

        companyRepository.save(company);
    }
}
