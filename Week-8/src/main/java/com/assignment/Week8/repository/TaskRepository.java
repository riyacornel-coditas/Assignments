package com.assignment.Week8.repository;

import com.assignment.Week8.entity.Tasks;
import com.assignment.Week8.enums.Priority;
import com.assignment.Week8.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Tasks, Long> {


    List<Tasks> findByEmployeeEmail(String email);

    List<Tasks> findByStatus(Status status);

    List<Tasks> findByPriority(Priority priority);

}
