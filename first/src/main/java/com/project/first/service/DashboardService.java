package com.project.first.service;

import com.project.first.entity.Company;
import com.project.first.entity.Employee;
import com.project.first.enums.Status;
import com.project.first.repository.CompanyRepository;
import com.project.first.repository.EmployeeRepository;
import com.project.first.repository.SubmissionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    public Map<String, Long> getDashboard(String name)
    {
        Company c = companyRepository.findByName(name)
                .orElseThrow(()->new EntityNotFoundException("Company not found"));

//        Long enrolled = employeeRepository.findByCompany(c.getName()).stream().count();

        List<Employee> employees = employeeRepository.findByCompany(c.getName());

        Long enrolled = (long) employees.size();

        Long active = employees.stream()
                .filter(e-> e.getStatus() == Status.ACTIVE)
                .count();

        Long bench = employees.stream()
                .filter(e -> e.getStatus() == Status.BENCH)
                .count();

        Map<String, Long> info = new HashMap<>();

        info.put("enrolled",enrolled);
        info.put("active", active);
        info.put("bench", bench);

        return info;


    }
}
