package com.interview.ps.repository;

import com.interview.ps.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);
}
