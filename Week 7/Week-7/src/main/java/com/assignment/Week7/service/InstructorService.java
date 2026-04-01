package com.assignment.Week7.service;

import com.assignment.Week7.entity.Course;
import com.assignment.Week7.entity.Instructor;
import com.assignment.Week7.entity.InstructorProfile;
import com.assignment.Week7.entity.Review;
import com.assignment.Week7.repository.CourseRepository;
import com.assignment.Week7.repository.InstructorProfileRepository;
import com.assignment.Week7.repository.InstructorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorProfileRepository instructorProfileRepository;

    @Transactional
    public Instructor createNewInstructor(Instructor instructor)
    {

        return instructorRepository.save(instructor);

    }

    @Transactional
    public InstructorProfile createNewInstructorProfile(Long id, InstructorProfile instructorProfile)
    {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found"));

        instructor.setInstructorProfile(instructorProfile);

        return instructorProfileRepository.save(instructorProfile);

    }


    public Instructor getInstructorById(Long instructorId)
    {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(()-> new EntityNotFoundException("Instructor not found"));

        return instructor;
    }

    public String deleteInstructorById(Long instructorId)
    {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(()-> new EntityNotFoundException("Instructor not found"));

        instructorRepository.deleteById(instructorId);

        return "Deleted";
    }

    public Instructor assignProfileToInstructor(Long profileId, Long instructorId)
    {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(()-> new EntityNotFoundException("Instructor not found"));

        InstructorProfile instructorProfile = instructorProfileRepository.findById(profileId)
                .orElseThrow();

        instructor.setInstructorProfile(instructorProfile);

        instructorRepository.save(instructor);

        return instructor;

    }

    @Transactional
    public String deleteInstructorProfile(Long instructorId)
    {
        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow();

        InstructorProfile profile = instructor.getInstructorProfile();

        if(profile!=null) {
            instructor.setInstructorProfile(null);
            profile.setInstructor(null);

            instructorRepository.save(instructor);
            instructorProfileRepository.delete(profile);
        }
        return "Deleted";


    }

    @Transactional
    public Instructor getInstructorWithCourses(@PathVariable Long id)
    {

        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Instructor not found"));
       instructor.getCourses().size();
        System.out.println("Courses:");
        return instructor;

    }

    @Transactional
    public Instructor addCoursesToInstructor(Long instructorId, List<Course> courses) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found"));

        for(Course c: courses) {
            instructor.addCourse(c);
        }

        return instructorRepository.save(instructor);

    }

}
