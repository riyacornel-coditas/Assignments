package com.project.first.repository;

import com.project.first.entity.Enrollment;
import com.project.first.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    @Query("SELECT COALESCE(MAX(s.attempt_number),0) FROM Submission s WHERE s.employee.id = :employeeId AND s.assignment.id = :assignmentId")
    Integer getMaxAttemptNumber(Long employeeId, Long assignmentId);

    List<Submission> findByEmployeeIdIn(List<Long> employeeIds);
}
