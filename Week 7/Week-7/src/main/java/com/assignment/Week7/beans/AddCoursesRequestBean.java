package com.assignment.Week7.beans;

import com.assignment.Week7.entity.Course;
import lombok.Data;


import java.util.List;

@Data
public class AddCoursesRequestBean {
    private Long instructorId;
    private List<Course> courses;
}
