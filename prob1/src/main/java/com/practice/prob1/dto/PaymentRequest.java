package com.practice.prob1.dto;

import lombok.Data;

@Data
public class PaymentRequest {

    private Long orderId;

    private double amount;
}
