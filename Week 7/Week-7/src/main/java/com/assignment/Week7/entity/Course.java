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
@Builder
@ToString(exclude = {"reviews", "students"})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    @JsonIgnore
    private Instructor instructor;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER,
    orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    public void addReview(Review review)
    {
        reviews.add(review);
        review.setCourse(this);
    }

    @ManyToMany(mappedBy = "courses" , fetch = FetchType.LAZY)
//    @JsonIgnore
    private List<Student> students = new ArrayList<>();


}
