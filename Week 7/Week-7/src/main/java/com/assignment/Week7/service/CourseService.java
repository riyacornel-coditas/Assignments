package com.assignment.Week7.service;

import com.assignment.Week7.entity.Course;
import com.assignment.Week7.entity.Instructor;
import com.assignment.Week7.entity.Review;
import com.assignment.Week7.entity.Student;
import com.assignment.Week7.repository.CourseRepository;
import com.assignment.Week7.repository.InstructorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final InstructorService instructorService;

    @Transactional
    public Course createNewCourse(Course course, Long instructorId)
    {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(()-> new EntityNotFoundException("Instructor not found"));

        course.setInstructor(instructor);

        instructor.getCourses().add(course);

        return courseRepository.save(course);

    }

    @Transactional
    public Course reAssignCourseToAnotherInstructor(Long courseId, Long instructorId)
    {
        Course course = courseRepository.findById(courseId).orElseThrow();
        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow();

        course.setInstructor(instructor); //this will automatically call for update as this is dirty

        instructor.getCourses().add(course); // to maintain bidirectional consistency
        return course;
    }

    @Transactional
    public Course addReviewsToCourse(Long courseId , List<Review> reviews) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));

//        Review r1 = new Review();
//        r1.setRating("Excellent course");
        for(Review r:reviews) {
            course.addReview(r);
        }
//        course.addReview(r1);

        return courseRepository.save(course);

    }

    @Transactional
    public Course getCourses(Long courseId)
    {
        return courseRepository.findById(courseId)
                .orElseThrow(()-> new EntityNotFoundException("Course not found"));
    }

    @Transactional
   public void deleteCourse(Long courseId)
   {
       Course course = courseRepository.findById(courseId)
               .orElseThrow(()-> new EntityNotFoundException("Course not found"));

       for(Student student : course.getStudents())
       {
           student.getCourses().remove(course);
       }

       Instructor instructor = course.getInstructor();
       if(instructor!=null)
       {
           instructor.getCourses().remove(course);
       }

       courseRepository.delete(course);
   }

}
