package com.assignment.Week5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto {
    private int id;
    private String name;
    private String profile;
    private int salary;
    private int experience;

}
