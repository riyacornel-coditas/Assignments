package com.project.first.requestdto;

import com.project.first.enums.SubmissionStatus;
import lombok.Data;

@Data
public class EvaluateDto {
    private SubmissionStatus submissionStatus;
}
