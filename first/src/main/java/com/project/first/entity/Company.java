package com.project.first.entity;

import com.project.first.enums.CompanyStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String type;

    @Enumerated(EnumType.STRING)
    private CompanyStatus companyStatus;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "company")
    private List<Employee> employee = new ArrayList<>();
}
