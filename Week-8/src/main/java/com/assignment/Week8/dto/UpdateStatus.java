package com.assignment.Week8.dto;

import com.assignment.Week8.enums.Status;
import lombok.Data;

@Data
public class UpdateStatus {
    private Long id;
    private Status status;
}
