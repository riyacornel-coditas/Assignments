package com.assignment.Week7.controller;

import com.assignment.Week7.entity.Course;
import com.assignment.Week7.entity.Instructor;
import com.assignment.Week7.entity.Student;
import com.assignment.Week7.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add")
    public Student createNewStudent(@RequestBody Student student)
    {
        return studentService.createNewStudent(student);
    }

    @PostMapping("/{studentId}/course/{courseId}")
    public Student enrollStudent(@PathVariable Long studentId,
                                 @PathVariable Long courseId)
    {
        return studentService.enrollStudent(studentId, courseId);
    }

    @GetMapping("/{id}/courses")
    public Student getStudentWithCourses(@PathVariable Long id) //not working
    {
        return studentService.getStudentWithCourses(id);
    }

    @PostMapping("/{studentId}/courses")
    public Student addCourses(@PathVariable Long studentId,
                                 @RequestBody List<Course> courses)
    {
        return studentService.addCoursesToStudent(studentId, courses);
    }

    @DeleteMapping("/{studentId}")
    public void deleteCourse(@PathVariable Long studentId)
    {
        studentService.deleteStudent(studentId);
    }


}
