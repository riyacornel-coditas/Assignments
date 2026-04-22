package com.assignment.Week9.repository;

import com.assignment.Week9.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
