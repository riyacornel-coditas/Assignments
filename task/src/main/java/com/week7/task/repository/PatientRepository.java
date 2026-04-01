package com.week7.task.repository;

import com.week7.task.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByMedicalHistory_BloodGroup(String bloodGroup);
}
