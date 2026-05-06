package com.project.first.controller;

import com.project.first.requestdto.EvaluateDto;
import com.project.first.requestdto.SubmissionDto;
import com.project.first.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/submission")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping("/make")
    public String makeSubmission(@RequestBody SubmissionDto submissionDto)
    {
        submissionService.makeSubmission(submissionDto);
        return "Submission done successfully";
    }

    @PatchMapping("/evaluate/{id}")
    public String evaluate(@PathVariable Long id, @RequestBody EvaluateDto evaluateDto)
    {
        return submissionService.evaluate(id, evaluateDto);
    }

}
