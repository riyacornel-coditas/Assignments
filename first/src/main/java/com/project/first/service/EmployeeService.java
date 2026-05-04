package com.project.first.service;

import com.project.first.entity.Employee;
import com.project.first.enums.Status;
import com.project.first.repository.EmployeeRepository;
import com.project.first.requestdto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void addEmployee(EmployeeDto employeeDto)
    {
        Employee e = new Employee();
        e.setName(employeeDto.getName());
        e.setEmail(employeeDto.getEmail());
        e.setPassword(employeeDto.getPassword());
        e.setStatus(Status.valueOf(employeeDto.getStatus()));
        employeeRepository.save(e);

    }
}
