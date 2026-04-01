package com.week7.task.controller;

import com.week7.task.entity.Patient;
import com.week7.task.entity.PatientMedicalRecord;
import com.week7.task.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PatientController {

    @Autowired
    private PatientService service;

    //Register a new Patient
    @PostMapping("/register")
    public Patient addPatient(@RequestBody Patient patient){
        service.addPatient(patient);
        return patient;
    }

    //view all Patients
    @GetMapping("/patients")
    public List<Patient> getAll(){
        return service.findAll();
    }

    //view patient detail by id
    @GetMapping("/getById/{id}")
    public Optional<Patient> getById(@PathVariable Integer id){
        return service.getById(id);
    }

    //view medical history of a particular patient
    @GetMapping("/patients/{id}/history")
    public PatientMedicalRecord getHistory(@PathVariable Integer id) {
        return service.getHistory(id);
    }
    //update patient details
    @PutMapping("/update/{id}")
    public Patient updatePatient(@PathVariable Integer id, @RequestBody Patient patient){
        return service.updatePatient(id,patient);
    }

    //Update medical history
    @PutMapping("/history/{id}")
    public PatientMedicalRecord updateHistory(@PathVariable Integer id, @RequestBody PatientMedicalRecord history) {
        return service.updateHistory(id, history);
    }

    //delete a patient and also the m_r associated with it
    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable Integer id){
        service.deletePatient(id);
    }

    //View all medical histories
    @GetMapping("/histories")
    public List<PatientMedicalRecord> getAllHistories() {
        return service.getAllMedicalHistories();
    }

    //Add medical history to existing patient
    @PostMapping("/{id}/history")
    public Patient addHistory(@PathVariable Integer id, @RequestBody PatientMedicalRecord history) {
        return service.addMedicalHistory(id, history);
    }

    //Find patients by blood group
    @GetMapping("/blood/{group}")
    public List<Patient> findByBloodGroup(@PathVariable String group) {
        return service.findByBloodGroup(group);
    }
}
