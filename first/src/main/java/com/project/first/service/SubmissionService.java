package com.project.first.service;

import com.project.first.entity.Assignment;
import com.project.first.entity.Employee;
import com.project.first.entity.Submission;
import com.project.first.repository.AssignmentRepository;
import com.project.first.repository.EmployeeRepository;
import com.project.first.repository.SubmissionRepository;
import com.project.first.requestdto.SubmissionDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final EmployeeRepository employeeRepository;
    private final AssignmentRepository assignmentRepository;

    public void makeSubmission(SubmissionDto submissionDto)
    {
        Submission s = new Submission();

        Assignment a = assignmentRepository.findById(submissionDto.getAssignmentId())
                .orElseThrow(()-> new EntityNotFoundException("Assignment not found"));

        Employee e = employeeRepository.findById(submissionDto.getEmployeeId())
                .orElseThrow(()-> new EntityNotFoundException("Employee not found"));

        s.setAssignment(a);
        s.setEmployee(e);
        s.setSolutionLink(submissionDto.getSolutionLink());
        submissionRepository.save(s);
    }
}
