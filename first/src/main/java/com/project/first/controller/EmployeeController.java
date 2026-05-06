package com.project.first.controller;

import com.project.first.entity.Employee;
import com.project.first.requestdto.EmployeeDto;
import com.project.first.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/employee")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add/to/company/{name}")
    public String addEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable String name)
    {
        employeeService.addEmployee(employeeDto, name);
        return "Employees added successfully";
    }

    @GetMapping("/get/all")
    public EmployeeDto getAll()
    {
        return employeeService.getAll();
    }

    @GetMapping("/get/by/id/{id}")
    public Employee get(@PathVariable Long id)
    {
        return employeeService.get(id);
    }


}
