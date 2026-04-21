package com.interview.ps.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aircraft {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String type;

    //add seating capacity



}
