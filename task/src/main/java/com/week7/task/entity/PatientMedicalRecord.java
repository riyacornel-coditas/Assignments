package com.week7.task.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatientMedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medical_Id;
    private String bloodGroup;
    private String allergies;
    private String past_Disease;
    private String current_Medication;

    @OneToOne(mappedBy = "patient_medical_record")
    private Patient patient;

}
