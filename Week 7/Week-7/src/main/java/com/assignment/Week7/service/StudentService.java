package com.assignment.Week7.service;

import com.assignment.Week7.entity.Course;
import com.assignment.Week7.entity.Instructor;
import com.assignment.Week7.entity.Student;
import com.assignment.Week7.repository.CourseRepository;
import com.assignment.Week7.repository.StudentRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public Student createNewStudent(Student student)
    {
        return studentRepository.save(student);

    }

    @Transactional
    public Student enrollStudent(Long studentId, Long courseId)
    {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new EntityNotFoundException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(()-> new EntityNotFoundException("Course not found"));

        student.addCourse(course);

        return studentRepository.save(student);

    }

    @Transactional
    public Student getStudentWithCourses(Long studentId)
    {
        return studentRepository.findById(studentId)
                .orElseThrow(()-> new EntityNotFoundException("Student not found"));


    }

    @Transactional
    public Student addCoursesToStudent(Long studentId, List<Course> courses) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        for(Course c: courses) {
            student.addCourse(c);
        }

        return studentRepository.save(student);

    }

    @Transactional
    public void deleteStudent(Long studentId)
    {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new EntityNotFoundException("Student not found"));

        for(Course course : student.getCourses())
        {
            course.getStudents().remove(student);
        }

        studentRepository.delete(student);
    }
}
