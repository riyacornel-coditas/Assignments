package com.project.first.entity;

import com.project.first.enums.SubmissionStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
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

    private Long id;

    @Enumerated(EnumType.STRING)
    private SubmissionStatus submissionStatus;

    @ManyToOne
    private Assignment assignment;

    @ManyToOne
    private Employee employee;

    private String solutionLink;


}
