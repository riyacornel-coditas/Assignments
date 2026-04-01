package com.week7.task.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientMedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medical_Id;
    private String patient_BloodGroup;
    private String allergies;
    private String past_Disease;
    private String current_Medication;

//    @OneToOne(mappedBy = "patient_medical_record")
//    private Patient patient;

    @Override
    public String toString() {
        return "PatientMedicalRecord{" +
                "medical_Id=" + medical_Id +
                ", patient_BloodGroup='" + patient_BloodGroup + '\'' +
                ", allergies='" + allergies + '\'' +
                ", past_Disease='" + past_Disease + '\'' +
                ", current_Medication='" + current_Medication + '\'' +
                '}';
    }
}
