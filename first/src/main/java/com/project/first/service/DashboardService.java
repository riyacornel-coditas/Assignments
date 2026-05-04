package com.project.first.service;

import com.project.first.enums.Status;
import com.project.first.repository.EmployeeRepository;
import com.project.first.repository.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final EmployeeRepository employeeRepository;

    public Map<String, Long> getDashboard()
    {
        Long enrolled = employeeRepository.count();

        Long active = employeeRepository.findAll().stream()
                .filter(e-> e.getStatus() == Status.ACTIVE)
                .count();

        Long bench = employeeRepository.findAll().stream()
                .filter(e -> e.getStatus() == Status.BENCH)
                .count();

        Map<String, Long> info = new HashMap<>();

        info.put("enrolled",enrolled);
        info.put("active", active);
        info.put("bench", bench);

        return info;


    }
}
