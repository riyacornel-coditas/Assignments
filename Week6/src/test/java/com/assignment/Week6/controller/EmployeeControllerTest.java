package com.assignment.Week6.controller;

import com.assignment.Week6.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.assignment.Week6.service.EmployeeService;
import com.assignment.Week6.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    private Employee emp1;
    private Employee emp2;


    @Test
    void testGetAll() {
        when(employeeService.getAll()).thenReturn(List.of(emp1, emp2));

        List<Employee> result = employeeController.getAll();

        assertEquals(2, result.size());
        verify(employeeService, times(1)).getAll();
    }


    @Test
    void testGetById_Valid() {
        when(employeeService.getAll()).thenReturn(List.of(emp1, emp2));
        when(employeeService.getById(1)).thenReturn(emp1);

        Employee result = employeeController.getById(1);

        assertNotNull(result);
        assertEquals("Abhi", result.getFirstName());
    }


    @Test
    void testGetById_Invalid() {
        when(employeeService.getAll()).thenReturn(List.of(emp1));

        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeController.getById(5);
        });
    }


    @Test
    void testGetByDepartment() {
        when(employeeService.getByDepartment("IT")).thenReturn(List.of(emp1));

        List<Employee> result = employeeController.getByDepartment("IT");

        assertEquals(1, result.size());
        assertEquals("IT", result.get(0).getDepartment());
    }


    @Test
    void testGetBySalary() {
        when(employeeService.getBySalary(50000)).thenReturn(List.of(emp1));

        List<Employee> result = employeeController.getBySalary(50000);

        assertEquals(1, result.size());
    }


    @Test
    void testSave() {
        Employee newEmp = new Employee();

        when(employeeService.save(any(Employee.class))).thenReturn(newEmp);

        Employee result = employeeController.save(newEmp);

        assertNull(result.getId());
        assertEquals("Sam", result.getFirstName());
    }


    @Test
    void testDeleteById() {
        doNothing().when(employeeService).deleteById(1);

        employeeController.deleteById(1);

        verify(employeeService, times(1)).deleteById(1);
    }


    @Test
    void testUpdateEmployee() {
        when(employeeService.save(emp1)).thenReturn(emp1);

        Employee result = employeeController.updateEmployee(emp1);

        assertEquals(emp1.getFirstName(), result.getFirstName());
    }


    @Test
    void testUpdatePartial() {
        Map<String, Object> updates = new HashMap<>();
        updates.put("salary", 70000);

        when(employeeService.updatePartial(1, updates)).thenReturn(emp1);

        Employee result = employeeController.updatePartial(1, updates);

        assertNotNull(result);
        verify(employeeService).updatePartial(1, updates);

    }
}