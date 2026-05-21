package com.project.second.controller;

import com.project.second.dtos.OrderRequest;
import com.project.second.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public String createOrder(@RequestBody OrderRequest request)
    {
        return orderService.createOrder(request);
    }

    @DeleteMapping("/cancel/{order_id}")
    public String cancelOrder(@PathVariable Integer order_id)
    {
        return orderService.cancelOrder(order_id);
    }

    @GetMapping("/bill/{id}")
    public String generateBill(@PathVariable Integer id)
    {
        return orderService.generateBill(id);
    }

}
