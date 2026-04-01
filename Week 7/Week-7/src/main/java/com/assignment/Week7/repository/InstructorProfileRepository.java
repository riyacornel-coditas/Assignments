package com.assignment.Week7.repository;

import com.assignment.Week7.entity.InstructorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorProfileRepository extends JpaRepository<InstructorProfile, Long> {
}
