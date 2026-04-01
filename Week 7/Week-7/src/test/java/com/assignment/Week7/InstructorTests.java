package com.assignment.Week7;

import com.assignment.Week7.entity.Course;
import com.assignment.Week7.entity.Instructor;
import com.assignment.Week7.entity.Review;
import com.assignment.Week7.entity.Student;
import com.assignment.Week7.repository.CourseRepository;
import com.assignment.Week7.repository.InstructorProfileRepository;
import com.assignment.Week7.repository.InstructorRepository;
import com.assignment.Week7.repository.StudentRepository;
import com.assignment.Week7.service.CourseService;
import com.assignment.Week7.service.InstructorService;
import com.assignment.Week7.service.StudentService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class InstructorTests {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private InstructorProfileRepository instructorProfileRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void tests()
    {
//        Instructor instructor = instructorService.getInstructorById(1L);
//        System.out.println(instructor);

//        boolean val = instructorService.deleteInstructorById(3L);
//        if(val==true)
//        {
//            System.out.println("Instructor has been deleted successfully");
//        }

        Instructor instructor1 =instructorService.assignProfileToInstructor(1L,1L);

        System.out.println(instructor1);

        Instructor instructor2 =instructorService.assignProfileToInstructor(2L,2L);

        System.out.println(instructor2);

        Instructor instructor3 =instructorService.assignProfileToInstructor(3L,3L);

        System.out.println(instructor3);

//        instructorService.deleteInstructorProfile(1L);
//        instructorProfileRepository.deleteById(1L);

    }

    @Test
    public void testCreateCourse()
    {
        Course course = Course.builder()
                .title("Commerce")
                .build();

        var newCourse= courseService.createNewCourse(course, 2L);


        System.out.println(newCourse);

        var updatedCourse = courseService.reAssignCourseToAnotherInstructor(newCourse.getId(), 1L);

        System.out.println(updatedCourse);

    }

//    @Test
//    public void testCourseReviewFlow()
//    {
//        Course course = courseService.addReviewsToCourse(1L);
//        System.out.println("After adding reviews");
//        System.out.println(course);
//
//        Course fetched = courseService.getCourses(1L);
//        System.out.println("Fetched course");
//        System.out.println(fetched.getTitle());
//        System.out.println("Reviews");
//        for(Review r: fetched.getReviews())
//        {
//            System.out.println(r.getRating());
//        }
//
//    }

//    @Test
//    @Transactional
//    public void getInstructorWithCourses()
//    {
//
//        Instructor instructor = instructorService.getInstructorById(1L);
//        System.out.println(instructor);
//        List<Course> courses = instructor.getCourses();
//        System.out.println("Courses:");
//        for (Course course : courses) {
//            System.out.println(course.getTitle());
//        }
//
//    }

    @Test
    public void testStudentCourse()
    {
        Student student = studentService.enrollStudent(1L,1L);
        System.out.println(student);
        System.out.println("Courses:");
        for(Course c : student.getCourses())
        {
            System.out.println(c.getTitle());
        }

    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testCourseWithStudents()
    {

        studentService.enrollStudent(1L,1L);
        studentService.enrollStudent(2L,1L);

        Course course = courseService.getCourses(1L);
        System.out.println("Course: "+course.getTitle());

        System.out.println("Students:");
        List<Student> students = course.getStudents();
        for(Student student: students) {
            System.out.println("Student: " + student.getName());

        }
        System.out.println("Student count: "+ course.getStudents().size());

    }

}
