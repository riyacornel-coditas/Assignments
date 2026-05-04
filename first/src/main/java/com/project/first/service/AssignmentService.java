package com.project.first.service;

import com.project.first.entity.Assignment;
import com.project.first.entity.Course;
import com.project.first.repository.AssignmentRepository;
import com.project.first.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final CourseRepository courseRepository;

    public void addAssignment(Assignment assignment, Long id)
    {
        Course course = courseRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Course not found"));

        Assignment a = new Assignment();
        a.setDescription(assignment.getDescription());
        a.setCourse(course);
        assignmentRepository.save(a);
    }
}
