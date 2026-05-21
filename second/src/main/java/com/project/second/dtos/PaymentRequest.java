package com.project.second.dtos;

import lombok.Data;

@Data
public class PaymentRequest {

    private Integer order_id;

    private String payment_mode;

    private String payment_details;

    private Double balance;

    private boolean payment_status;
}
