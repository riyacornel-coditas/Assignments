package com.assignment.Week5.repository;

import com.assignment.Week5.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

    List<Staff> findBySalaryGreaterThan(Integer salary);

    List<Staff> findByExperienceBetween(Integer start, Integer end);

    @Query("SELECT s FROM Staff s WHERE s.salary = (SELECT MAX(s.salary) FROM Staff s)")
    Staff findMaxSalary();

    @Query("SELECT s FROM Staff s WHERE s.experience = (SELECT MIN(s.experience) FROM Staff s)")
    Staff findMinExperience();

    @Query("SELECT s FROM Staff s WHERE s.profile = 'Trainer' ")
    List<Staff> findTrainer();

    @Query("SELECT s FROM Staff s WHERE s.profile != 'Trainer' ")
    List<Staff> findNotTrainer();

}
