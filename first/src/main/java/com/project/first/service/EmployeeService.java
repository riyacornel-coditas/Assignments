package com.project.first.service;

import com.project.first.entity.Company;
import com.project.first.entity.Course;
import com.project.first.entity.Employee;
import com.project.first.enums.Status;
import com.project.first.repository.CompanyRepository;
import com.project.first.repository.CourseRepository;
import com.project.first.repository.EmployeeRepository;
import com.project.first.repository.UserDetailsRepository;
import com.project.first.requestdto.EmployeeDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;


    public void addEmployee(List<EmployeeDto> employeeDtos, String name)
    {
        Company c = companyRepository.findByName(name)
               .orElseThrow(()-> new EntityNotFoundException("Company not found"));

        List<Employee> employees = new ArrayList<>();

        for(EmployeeDto e: employeeDtos)
        {
            Employee employee = new Employee();

            employee.setName(e.getName());
            employee.setEmail(e.getEmail());
            employee.setPassword(e.getPassword());
            employee.setCompany(c);
            employee.setCertified(e.isCertified());
            employee.setStatus(e.getStatus());

            employees.add(employee);
        }

        employeeRepository.saveAll(employees);

//        Company c = companyRepository.findByName(employeeDto.getCompanyName())
//                .orElseThrow(()-> new EntityNotFoundException("Company not found"));
//
//        Employee e = new Employee();
//        e.setName(employeeDto.getName());
//        e.setEmail(employeeDto.getEmail());
//        e.setPassword(employeeDto.getPassword());
//        e.setStatus(Status.valueOf(employeeDto.getStatus()));
//        e.setCertified(employeeDto.isCertified());
//        e.setCompany(c);
//
//        employeeRepository.save(e);

    }

    public List<EmployeeDto> getAll() {
        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for(Employee e: employees) {
            EmployeeDto dto = new EmployeeDto();
            dto.setName(e.getName());
            dto.setEmail(e.getEmail());
            dto.setPassword(e.getPassword());
            dto.setStatus(e.getStatus());
            dto.setCompanyName(e.getCompany().getName());
            dto.setCertified(e.isCertified());

            employeeDtos.add(dto);
        }

        return employeeDtos;
    }

    public Employee get(Long id) {
        Employee e = employeeRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Employee not found"));

        return e;
    }
}
