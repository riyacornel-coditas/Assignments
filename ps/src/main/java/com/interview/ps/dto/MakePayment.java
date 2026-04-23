package com.interview.ps.dto;

import lombok.Data;

@Data
public class MakePayment {
    private String paymentMode;

    private String paymentDetails;

    private Double balance;

    private Long userId;

    private Long bookingId;
}
