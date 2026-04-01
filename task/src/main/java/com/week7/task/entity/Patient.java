package com.week7.task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "Patient{" +
                "patient_Id=" + patient_Id +
                ", patient_name='" + patient_name + '\'' +
                ", patient_age=" + patient_age +
                ", patient_gender='" + patient_gender + '\'' +
                ", phone_number=" + phone_number +
                '}';
    }

    public PatientMedicalRecord getMedicalRecord() {

        return patient_medical_record;
    }
}

