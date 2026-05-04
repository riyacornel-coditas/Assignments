package com.project.first.requestdto;

import lombok.Data;

@Data
public class SubmissionDto {

    private Long employeeId;

    private Long assignmentId;

    private String solutionLink;
}
