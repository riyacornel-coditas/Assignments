package com.project.first.entity;

import com.project.first.enums.EnrollmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status;

    private Integer attempt_count = 0;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Course course;
}
