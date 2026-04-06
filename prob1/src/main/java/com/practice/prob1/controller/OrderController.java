package com.practice.prob1.controller;

import com.practice.prob1.dto.OrderRequest;
import com.practice.prob1.entity.Order;
import com.practice.prob1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public Order createOrder(@RequestBody OrderRequest order)
    {
        return orderService.placeOrder(order.getUserId(), order.getProductId(), order.getQuantity());
    }

    @PostMapping("/cancel")
    public Order cancelOrder(@PathVariable Long id) {
        return orderService.cancelOrder(id);

    }
}
