package com.assignment.Week7.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Cacheable

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"courses"})
@Builder
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column( nullable = false, length=40)
    private String name;


    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_profile_id")
    private InstructorProfile instructorProfile;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course)
    {
        courses.add(course);
        course.setInstructor(this);
    }

}
