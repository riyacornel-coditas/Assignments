package com.interview.ps.dto;

import com.interview.ps.entity.Airline;
import lombok.Data;

import java.util.List;

@Data
public class AddAircraft {

    private String name;

    private String type;

    private Integer capacity;

    private Long airlineId;
}
