package com.project.first.controller;

import com.project.first.entity.Assignment;
import com.project.first.requestdto.AssignmentDto;
import com.project.first.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assignment")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping("/add/to/course/{title}")
    public String addAssignment(@PathVariable String title, @RequestBody AssignmentDto assignmentDto)
    {
        assignmentService.addAssignment(title, assignmentDto);
        return "Assignment for course added successfully";
    }
}
