package com.assignment.Week6.service;

import com.assignment.Week6.dao.EmployeeDao;
import com.assignment.Week6.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao)
    {
        this.employeeDao=employeeDao;
    }

    @Override
    public List<Employee> getAll() {
       return employeeDao.getAll();
    }

    @Override
    public Employee getById(Integer id) {
        return employeeDao.getById(id);
    }

    @Override
    public List<Employee> getByDepartment(String department) {
        return employeeDao.getByDepartment(department);
    }

    @Override
    public List<Employee> getBySalary(Integer salary) {
        return employeeDao.getBySalary(salary);
    }


    @Override
    @Transactional
    public Employee save(Employee employee) {

        return employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
         employeeDao.deleteById(id);
    }

    @Override
    @Transactional
    public Employee updatePartial(Integer id, Map<String, Object> updates) {

        Employee dbEmployee = employeeDao.getById(id);

        updates.forEach((field,value)->{
            switch(field){
                case "salary" : dbEmployee.setSalary((Integer) value);
                break;
                case "firstName" : dbEmployee.setFirstName((String) value);
                    break;
                case "lastName" : dbEmployee.setLastName((String) value);
                    break;
                case "department" : dbEmployee.setDepartment((String) value);
                    break;
                case "email" : dbEmployee.setEmail((String) value);
                    break;
                default: throw new IllegalArgumentException("Student not found");

            }
        });

Employee savedEmployee= employeeDao.save(dbEmployee);
return savedEmployee;
    }

}
