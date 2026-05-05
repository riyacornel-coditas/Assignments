package com.project.first.controller;

import com.project.first.requestdto.EmployeeDto;
import com.project.first.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/employee")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public String addEmployee(@RequestBody EmployeeDto employeeDto)
    {
        employeeService.addEmployee(employeeDto);
        return "Employee added successfully";
    }


}
