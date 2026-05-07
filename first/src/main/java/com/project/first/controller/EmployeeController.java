package com.project.first.controller;

import com.project.first.entity.Employee;
import com.project.first.requestdto.EmployeeDto;
import com.project.first.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/employees")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/companies/{companyName}")
    public String addEmployeeToCompany(@Valid @RequestBody List<EmployeeDto> employeeDtos, @PathVariable String companyName)
    {
        employeeService.addEmployeeToCompany(employeeDtos, companyName);
        return "Employees added successfully";
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId)
    {
        return employeeService.getEmployeeById(employeeId);
    }


}
