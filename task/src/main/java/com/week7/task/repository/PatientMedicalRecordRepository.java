package com.week7.task.repository;

import com.week7.task.entity.PatientMedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientMedicalRecordRepository extends JpaRepository<PatientMedicalRecord, Integer> {
}
