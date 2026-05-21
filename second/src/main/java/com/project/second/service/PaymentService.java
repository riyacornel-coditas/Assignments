package com.project.second.service;

import com.project.second.dtos.PaymentRequest;
import com.project.second.entity.Order;
import com.project.second.entity.Payment;
import com.project.second.entity.Restaurant;
import com.project.second.exception.InvalidPaymentException;
import com.project.second.exception.OrderNotFoundException;
import com.project.second.exception.PaymentProcessingException;
import com.project.second.repository.OrderRepository;
import com.project.second.repository.PaymentRepository;
import com.project.second.repository.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public String makePayment(PaymentRequest request)
    {
        if (request == null) {

            throw new InvalidPaymentException("Payment request cannot be null");
        }

        if (request.getOrder_id() == null) {

            throw new InvalidPaymentException("Order id is required");
        }

        if (request.getBalance() == null || request.getBalance() <= 0) {

            throw new InvalidPaymentException("Payment amount must be greater than 0");
        }

        if (request.getPayment_mode() == null) {

            throw new InvalidPaymentException("Payment mode is required");
        }

        try {
            Order order = orderRepository.findById(request.getOrder_id())
                    .orElseThrow(() -> new OrderNotFoundException("Order not found"));

            Payment payment = new Payment();

            payment.setPayment_details(request.getPayment_details());
            payment.setPayment_mode(request.getPayment_mode());
            payment.setBalance(request.getBalance());
            payment.setOrder(order);

            Double amount_paid = request.getBalance();

            Double total = order.getTotal();

            if (amount_paid >= total) {
                Double remaining = amount_paid - total;
                payment.setBalance(remaining);
                payment.setPayment_status(true);

                Restaurant restaurant = order.getRestaurant();

                Double currentRevenue = restaurant.getRevenue() == null ? 0.0 : restaurant.getRevenue();
                restaurant.setRevenue(currentRevenue + order.getTotal());

                restaurantRepository.save(restaurant);

                paymentRepository.save(payment);
                return "Payment successful";

            }

            payment.setBalance(total - amount_paid);
            payment.setPayment_status(false);
            paymentRepository.save(payment);
            return "Insufficient balance";
        }catch (Exception e) {
            e.printStackTrace();
            throw new PaymentProcessingException(e.getMessage());
        }
    }
}
