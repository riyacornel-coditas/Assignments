package com.project.first.requestdto;

import lombok.Data;

@Data
public class SubmitRequestDto {
    private Long employeeId;
    private Long assignmentId;
    private String submissionLink;
}
