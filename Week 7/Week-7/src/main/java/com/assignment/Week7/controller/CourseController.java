package com.assignment.Week7.controller;

import com.assignment.Week7.beans.AddReviewsRequestBean;
import com.assignment.Week7.entity.Course;
import com.assignment.Week7.entity.Review;
import com.assignment.Week7.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id)
    {
        return courseService.getCourses(id);
    }

    @PostMapping("/instructor/{instructorId}")
    public Course createNewCourse(@RequestBody Course course,
                                  @PathVariable Long instructorId)
    {
        return courseService.createNewCourse(course, instructorId);
    }

    @PutMapping("reassign/{courseId}/{instructorId}")
    public Course reassignCourseToAnotherInstructor(@PathVariable Long courseId,
                                                    @PathVariable Long instructorId)
    {
        return courseService.reAssignCourseToAnotherInstructor(courseId,instructorId);
    }

    @GetMapping("/{id}/students")
    public Course getCourseWithStudents(@PathVariable Long id)
    {
        return courseService.getCourses(id);
    }

    @PostMapping("/{courseId}/reviews")
    public Course addReviews(AddReviewsRequestBean requestBean)
    {
        return courseService.addReviewsToCourse(requestBean);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable Long courseId)
    {
        courseService.deleteCourse(courseId);
    }


}
