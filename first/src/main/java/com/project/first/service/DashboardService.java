package com.project.first.service;

import com.project.first.entity.Company;
import com.project.first.entity.Employee;
import com.project.first.entity.Enrollment;
import com.project.first.entity.Submission;
import com.project.first.enums.EnrollmentStatus;
import com.project.first.enums.Status;
import com.project.first.enums.SubmissionStatus;
import com.project.first.repository.CompanyRepository;
import com.project.first.repository.EmployeeRepository;
import com.project.first.repository.EnrollmentRepository;
import com.project.first.repository.SubmissionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
    private final EnrollmentRepository enrollmentRepository;
    private final SubmissionRepository submissionRepository;

    @Transactional
    public Map<String, Long> getCompanyDashboard(String companyName)
    {
        Company c = companyRepository.findByName(companyName)
                .orElseThrow(()->new EntityNotFoundException("Company not found"));


        List<Employee> employees = employeeRepository.findByCompany(c.getId());

        List<Long> employeeIds = employees.stream()
                .map(Employee::getId).toList();

        List<Enrollment> enrollments = enrollmentRepository.findByEmployeeIdIn(employeeIds);

        Long enrolledCount = enrollments.stream()
                .map(e-> e.getEmployee().getId())
                .distinct()
                .count();

        Long active = employees.stream()
                .filter(e-> e.getStatus() == Status.ACTIVE)
                .count();

        Long bench = employees.stream()
                .filter(e -> e.getStatus() == Status.BENCH)
                .count();

        List<Submission> submissions = submissionRepository.findByEmployeeIdIn(employeeIds);

        Long certifiedCount = submissions.stream()
                .filter(s->s.getSubmissionStatus() == SubmissionStatus.PASSED)
                .count();


        Map<String, Long> info = new HashMap<>();

        info.put("active", active);
        info.put("bench", bench);
        info.put("enrolled",enrolledCount);
        info.put("certified",certifiedCount);

        return info;


    }
}
