package com.assignment.Week8.dto;

import com.assignment.Week8.enums.Priority;
import lombok.Data;

@Data
public class UpdatePriority {
    private Long id;
    private Priority priority;
}
