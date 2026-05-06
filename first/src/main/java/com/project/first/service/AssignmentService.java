package com.project.first.service;

import com.project.first.entity.Assignment;
import com.project.first.entity.Course;
import com.project.first.repository.AssignmentRepository;
import com.project.first.repository.CourseRepository;
import com.project.first.requestdto.AssignmentDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final CourseRepository courseRepository;

    public void addAssignment(String title, AssignmentDto assignmentDto)
    {
        Course course = courseRepository.findByTitle(title).orElseThrow(()-> new EntityNotFoundException("Course not found"));

        Assignment a = new Assignment();
        a.setDescription(assignmentDto.getDescription());
        a.setCourse(course);
        assignmentRepository.save(a);
    }
}
