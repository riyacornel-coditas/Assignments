package com.assignment.Week6.service;

import com.assignment.Week6.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getById(Integer id);

    List<Employee> getByDepartment(String department);

    List<Employee> getBySalary(Integer salary);

    Employee save(Employee employee);

    void deleteById(Integer id);

    Employee updatePartial(Integer id, Map<String, Object> updates);
}
