package com.project.first.controller;

import com.project.first.entity.Assignment;
import com.project.first.requestdto.AssignmentDto;
import com.project.first.service.AssignmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping("/course/{courseTitle}")
    public String addAssignment(@PathVariable String courseTitle,@Valid @RequestBody AssignmentDto assignmentDto)
    {
        assignmentService.addAssignmentToCourse(courseTitle, assignmentDto);
        return "Assignment for course added successfully";
    }
}
