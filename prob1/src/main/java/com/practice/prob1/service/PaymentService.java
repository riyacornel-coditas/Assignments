package com.practice.prob1.service;

import com.practice.prob1.dto.PaymentRequest;
import com.practice.prob1.entity.Order;
import com.practice.prob1.entity.Payment;
import com.practice.prob1.repository.OrderRepository;
import com.practice.prob1.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;


    public Payment processPayment(PaymentRequest paymentRequest)
    {

        Order order = orderRepository.findById(paymentRequest.getOrderId())
                .orElseThrow(()->new RuntimeException("Order not found"));



        if(paymentRequest.getAmount() <= 0)
        {
            throw new RuntimeException("Invalid payment");
        }

        if(paymentRequest.getAmount() > 10000)
        {
            throw new RuntimeException("Limit exceeded");
        }

        Payment payment = new Payment();
        payment.setOrderId(paymentRequest.getOrderId());
        payment.setAmount(paymentRequest.getAmount());
        payment.setStatus("SUCCESS");

        return paymentRepository.save(payment);

    }


}
