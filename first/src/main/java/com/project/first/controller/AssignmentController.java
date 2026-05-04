package com.project.first.controller;

import com.project.first.entity.Assignment;
import com.project.first.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assignment")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping("/add/to/course/{id}")
    public String addAssignment(@PathVariable Long id, @RequestBody Assignment assignment)
    {
        assignmentService.addAssignment(assignment, id);
        return "Assignment for course added successfully";
    }
}
