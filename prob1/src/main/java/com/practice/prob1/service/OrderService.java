package com.practice.prob1.service;

import com.practice.prob1.entity.Order;
import com.practice.prob1.entity.Product;
import com.practice.prob1.entity.User;
import com.practice.prob1.repository.OrderRepository;
import com.practice.prob1.repository.ProductRepository;
import com.practice.prob1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Order placeOrder(Long productId, Long userId, Integer quantity)
    {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new RuntimeException("Product not found"));

        if(product.getStock() < quantity)
        {
            throw new RuntimeException("Not in stock!");
        }

        product.setStock(product.getStock() - quantity);
        productRepository.save(product);

        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setQuantity(quantity);
        order.setStatus("CREATED");

        return orderRepository.save(order);
    }

    public Order cancelOrder(Long orderId)
    {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()-> new RuntimeException("Order not found"));

        order.setStatus("CANCELLED");

        return orderRepository.save(order);
    }
}
