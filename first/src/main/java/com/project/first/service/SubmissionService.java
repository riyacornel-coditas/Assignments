package com.project.first.service;

import com.project.first.entity.Assignment;
import com.project.first.entity.Employee;
import com.project.first.entity.Enrollment;
import com.project.first.entity.Submission;
import com.project.first.enums.EnrollmentStatus;
import com.project.first.enums.SubmissionStatus;
import com.project.first.repository.AssignmentRepository;
import com.project.first.repository.EmployeeRepository;
import com.project.first.repository.EnrollmentRepository;
import com.project.first.repository.SubmissionRepository;
import com.project.first.requestdto.EvaluateDto;
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
    private final EnrollmentRepository enrollmentRepository;

    public void createSubmission(SubmissionDto submissionDto)
    {
        if(!submissionDto.getSolutionLink().startsWith("http"))
        {
            throw new RuntimeException("Invalid solution link");
        }

        Submission s = new Submission();

        Assignment a = assignmentRepository.findById(submissionDto.getAssignmentId())
                .orElseThrow(()-> new EntityNotFoundException("Assignment not found"));

        Employee e = employeeRepository.findById(submissionDto.getEmployeeId())
                .orElseThrow(()-> new EntityNotFoundException("Employee not found"));

        Enrollment enrollment = enrollmentRepository.findByEmployeeIdAndCourseId(e.getId(), a.getCourse().getId())
                .orElseThrow(()-> new EntityNotFoundException("Enrollment not found"));


        s.setAssignment(a);
        s.setEmployee(e);
        s.setSolutionLink(submissionDto.getSolutionLink());

        Integer lastAttempt = submissionRepository.getMaxAttemptNumber(e.getId(), a.getId());

        if(lastAttempt>=3)
        {
            throw new RuntimeException("Max attempts exceeded");
        }

        Integer attempt_number = lastAttempt + 1;
        s.setAttempt_number(attempt_number);

        if(e.isCertified())
        {
            throw new RuntimeException("Employee already certified");
        }

        if (submissionDto.getSolutionLink().contains("github")) {

            s.setSubmissionStatus(SubmissionStatus.PASSED);

            enrollment.setStatus(EnrollmentStatus.COMPLETED);
            e.setCertified(true);

        } else {

            s.setSubmissionStatus(SubmissionStatus.FAILED);

            enrollment.setStatus(EnrollmentStatus.IN_PROGRESS);
        }


        employeeRepository.save(e);
        submissionRepository.save(s);
        enrollmentRepository.save(enrollment);
        //evaluate()
    }

//    public String evaluate(Long id, EvaluateDto evaluateDto) {
//        Submission s = submissionRepository.findById(id)
//                .orElseThrow(()-> new EntityNotFoundException("Submission for assignment not found"));
//
//            Employee e = s.getEmployee();
//
//            Assignment a = s.getAssignment();
//
//
//
//
//        if(s.getSubmissionStatus()==SubmissionStatus.PENDING)
//        {
//            if(evaluateDto.getSubmissionStatus()==SubmissionStatus.PASSED)
//            {
//                s.setSubmissionStatus(SubmissionStatus.PASSED);
//                enrollment.setStatus(EnrollmentStatus.COMPLETED);
//                e.setCertified(true);
//            }
//            else
//            {
//                s.setSubmissionStatus(SubmissionStatus.FAILED);
//            }
//            submissionRepository.save(s);
//        }
//
//            return "Assignment already evaluated";
//
//
//    }
}
