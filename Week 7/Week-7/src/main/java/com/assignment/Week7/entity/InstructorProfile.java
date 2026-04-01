package com.assignment.Week7.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Cacheable

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"instructor"})
@Builder
public class InstructorProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String bio;

    private Integer experience;

    @JsonIgnore
    @OneToOne(mappedBy = "instructorProfile")
    private Instructor instructor;
}
