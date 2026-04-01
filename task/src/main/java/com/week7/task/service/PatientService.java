package com.week7.task.service;

import com.week7.task.entity.Patient;
import com.week7.task.entity.PatientMedicalRecord;
import com.week7.task.repository.PatientMedicalRecordRepository;
import com.week7.task.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private PatientMedicalRecordRepository medicalRecord;

    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    public List<Patient> findAll() {
        return patientRepo.findAll();
    }

    public Optional<Patient> getById(Integer id) {
        return patientRepo.findById(id);
    }

    public PatientMedicalRecord getHistory(Integer id) {
        Patient patient = patientRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        return patient.getMedicalRecord();
    }

    public Patient updatePatient(Integer id, Patient patient) {
        Patient patient1 = patientRepo.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Patient Not found"));
        patient1.setPatient_name(patient.getPatient_name());
        patient1.setPatient_age(patient.getPatient_age());
        patient1.setPatient_gender(patient.getPatient_gender());
        return patientRepo.save(patient1);
    }

    public void deletePatient(Integer id) {
        patientRepo.deleteById(id);
    }

    public PatientMedicalRecord updateHistory(Integer id, PatientMedicalRecord updated) {
        PatientMedicalRecord history = medicalRecord.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Patient Not found"));
        history.setAllergies(updated.getAllergies());
        history.setPast_Disease(updated.getPast_Disease());
        history.setCurrent_Medication(updated.getCurrent_Medication());
        return medicalRecord.save(history);

    }

    public List<PatientMedicalRecord> getAllMedicalHistories() {
        return medicalRecord.findAll();
    }

    public Patient addMedicalHistory(Integer id, PatientMedicalRecord history) {
        Patient patient = patientRepo.findById(id).orElseThrow();
        patient.setPatient_medical_record(history);
        return patientRepo.save(patient);

    }

    public List<Patient> findByBloodGroup(String group) {
        return patientRepo.findByMedicalHistory_BloodGroup(group);
    }
}
