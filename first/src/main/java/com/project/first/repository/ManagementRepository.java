package com.project.first.repository;

import com.project.first.entity.Management;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagementRepository extends JpaRepository<Management, Long> {
}
