package com.assignment.Week6.dao;

import com.assignment.Week6.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeDao extends JpaRepository<Employee, Integer> {



    List<Employee> getAll();

    Employee getById(Integer id);

    List<Employee> getByDepartment(String department);

    List<Employee> getBySalary(Integer salary);

    Employee save(Employee employee);

    void deleteById(Integer id);
}
