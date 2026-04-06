package com.practice.prob1.controller;

import com.practice.prob1.dto.PaymentRequest;
import com.practice.prob1.entity.Payment;
import com.practice.prob1.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/makePayment")
    public Payment makePayment(@RequestBody PaymentRequest paymentRequest)
    {
        return paymentService.processPayment(paymentRequest);
    }

}
