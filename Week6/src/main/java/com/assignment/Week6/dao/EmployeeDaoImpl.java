package com.assignment.Week6.dao;

import com.assignment.Week6.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAll() {

        TypedQuery<Employee> q1 = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = q1.getResultList();

        return employees;
    }

    @Override
    public Employee getById(Integer id) {

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public List<Employee> getByDepartment(String department) {

        TypedQuery<Employee> q1 = entityManager.createQuery("from Employee e where lower(e.department) = lower(:dept)", Employee.class);

        q1.setParameter("dept", department);
        List<Employee> employees = q1.getResultList();

        return employees;
    }

    @Override
    public List<Employee> getBySalary(Integer salary) {
        TypedQuery<Employee> q1 = entityManager.createQuery("from Employee e where e.salary > :sal", Employee.class);

        q1.setParameter("sal", salary);
        List<Employee> employees = q1.getResultList();

        return employees;
    }

    public Employee save(Employee employee)
    {
        Employee dbEmployee = entityManager.merge(employee);

        return dbEmployee;
    }

    @Override
    public void deleteById(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
