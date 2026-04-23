package com.interview.ps.controller;

import com.interview.ps.dto.MakePayment;
import com.interview.ps.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

     private final PaymentService paymentService;

     @PostMapping("/add/details")
     public String addPaymentDetails(@RequestBody MakePayment makePayment)
     {
         paymentService.addPaymentDetails(makePayment);
         return "Payment details added";
     }

     @PostMapping("/make/payment/{id}")
     public String makePayment(@PathVariable Long id)
     {
          paymentService.makePayment(id);
          return "Payment successful";
     }
}
