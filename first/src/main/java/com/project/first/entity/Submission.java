package com.project.first.entity;

import com.project.first.enums.EnrollmentStatus;
import com.project.first.enums.SubmissionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Submission {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private SubmissionStatus submissionStatus;

    @ManyToOne
    @JoinColumn(name="assignmentId")
    private Assignment assignment;

    @ManyToOne
    private Employee employee;

    private String solutionLink;

//   private EnrollmentStatus enrollmentStatus;




}
