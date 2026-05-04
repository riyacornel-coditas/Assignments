package com.project.first.service;

import com.project.first.entity.Company;
import com.project.first.entity.Course;
import com.project.first.entity.Employee;
import com.project.first.enums.Status;
import com.project.first.repository.CompanyRepository;
import com.project.first.repository.CourseRepository;
import com.project.first.repository.EmployeeRepository;
import com.project.first.requestdto.EmployeeDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final CourseRepository courseRepository;

    public void addEmployee(EmployeeDto employeeDto)
    {
        Company c = companyRepository.findById(employeeDto.getCompanyId())
                .orElseThrow(()-> new EntityNotFoundException("Company not found"));

        Course course = courseRepository.findById(employeeDto.getCourseId())
                .orElseThrow(()-> new EntityNotFoundException("Course not found"));

        Employee e = new Employee();
        e.setName(employeeDto.getName());
        e.setEmail(employeeDto.getEmail());
        e.setPassword(employeeDto.getPassword());
        e.setStatus(Status.valueOf(employeeDto.getStatus()));
        e.setCompany(c);
        e.setCourse(course);
        employeeRepository.save(e);

    }
}
