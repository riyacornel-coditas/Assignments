package com.assignment.Week7.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;

import java.util.ArrayList;
import java.util.List;


@Cacheable

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude={"courses"})
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="course_id")
    )
//    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course)
    {
        this.courses.add(course);

        if(course.getStudents() == null)
        {
            course.setStudents(new ArrayList<>());
        }
        course.getStudents().add(this);
    }
}
