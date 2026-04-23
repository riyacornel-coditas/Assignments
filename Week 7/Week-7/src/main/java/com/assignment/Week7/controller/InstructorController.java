package com.assignment.Week7.controller;

import com.assignment.Week7.beans.AddCoursesRequestBean;
import com.assignment.Week7.entity.Course;
import com.assignment.Week7.entity.Instructor;
import com.assignment.Week7.entity.InstructorProfile;
import com.assignment.Week7.entity.Review;
import com.assignment.Week7.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping("/addInstructor")
    public Instructor createNewInstructor(@RequestBody  Instructor instructor)
    {
        return instructorService.createNewInstructor(instructor);
    }

    @PostMapping("/addInstructorProfile/{id}")
    public InstructorProfile createNewInstructorProfile(@PathVariable Long id, @RequestBody InstructorProfile instructorProfile)
    {
        return instructorService.createNewInstructorProfile(id, instructorProfile);
    }

    @GetMapping("/{id}")
    public Instructor getInstructor(@PathVariable Long id)
    {
        return instructorService.getInstructorById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteInstructor(@PathVariable Long id)
    {
       return instructorService.deleteInstructorById(id);

    }

    @PostMapping("/{instructorId}/profile/{profileId}")// not needed also skip ids
    public Instructor assignProfile(@PathVariable Long instructorId,
                                    @PathVariable Long profileId)
    {
        return instructorService.assignProfileToInstructor(profileId,instructorId);
    }

    @DeleteMapping("/{id}/profile")
    public String deleteInstructorPro(@PathVariable Long id)
    {
        return instructorService.deleteInstructorProfile(id);

    }

    @GetMapping("/{id}/courses")
    public Instructor getInstructorWithCourses(@PathVariable Long id)
    {
        return instructorService.getInstructorWithCourses(id);
    }

    @PostMapping("/{instructorId}/courses")
    public  Instructor addCourses(@RequestBody AddCoursesRequestBean requestBean)
    {
        return instructorService.addCoursesToInstructor(requestBean);
    }// to add the instructor id in json payload
    //addcoursesrequestbean
}
