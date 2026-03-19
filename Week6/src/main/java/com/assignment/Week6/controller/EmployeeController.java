package com.assignment.Week6.controller;

import com.assignment.Week6.entity.Employee;
import com.assignment.Week6.exception.EmployeeErrorResponse;
import com.assignment.Week6.exception.EmployeeNotFoundException;
import com.assignment.Week6.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }

    @GetMapping("/")
    public List<Employee> getAll()
    {
        return employeeService.getAll();
    }

    @GetMapping("/{employeeId}")
    public Employee getById(@PathVariable Integer employeeId)
    {
        if(employeeId<0 || employeeId >= employeeService.getAll().size())
        {
            throw new EmployeeNotFoundException("Employee with id "+ employeeId +"not found");
        }

        return employeeService.getById(employeeId);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getByDepartment(@PathVariable String department)
    {
        return employeeService.getByDepartment(department);
    }

    @GetMapping("/salary/{salary}")
    public List<Employee> getBySalary(@PathVariable Integer salary)
    {
        return employeeService.getBySalary(salary);
    }

    @PostMapping("/")
    public Employee save(@Valid @RequestBody Employee employee)
    {
        employee.setId(null);
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id)
    {
        employeeService.deleteById(id);
    }

    @PutMapping("/")
    public Employee updateEmployee(@Valid @RequestBody Employee employee)
    {
        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    @PatchMapping("/{id}")
    public Employee updatePartial(@PathVariable Integer id, @Valid @RequestBody Map<String,Object> updates)
    {
        return employeeService.updatePartial(id,updates);
    }


}
