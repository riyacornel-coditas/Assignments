package com.project.second.controller;

import com.project.second.dtos.PaymentRequest;
import com.project.second.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/make")
    public String makePayment(@RequestBody PaymentRequest request)
    {
        return paymentService.makePayment(request);
    }
}
