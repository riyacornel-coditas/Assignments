package com.week7.task.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patient_Id;
    private String patient_name;
    private int patient_age;
    private String patient_gender;
    private long phone_number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_medical_record_id")
    private PatientMedicalRecord patient_medical_record;

    public PatientMedicalRecord getMedicalRecord() {

        return patient_medical_record;
    }
}

