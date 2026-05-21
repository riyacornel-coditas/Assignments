package com.project.second.service;

import com.project.second.dtos.OrderItemRequest;
import com.project.second.dtos.OrderRequest;
import com.project.second.entity.*;
import com.project.second.exception.*;
import com.project.second.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final DishRepository dishRepository;
    private final RestaurantBranchRepository restaurantBranchRepository;
    private final RestaurantRepository restaurantRepository;

    private final BillPdfService pdfService;

    public String createOrder(OrderRequest request)
    {
        if (request == null) {
            throw new InvalidOrderException("Order request cannot be null");
        }

        if (request.getItems() == null) {
            throw new InvalidOrderException("Order items cannot be empty");
        }

        try {
            Order order = new Order();

            Restaurant restaurant = restaurantRepository.findById(request.getRestaurant_id())
                            .orElseThrow(()-> new RestaurantNotFoundException("Restaurant not found"));

            RestaurantBranch restaurantBranch = restaurantBranchRepository.findById(request.getBranch_id())
                            .orElseThrow(()-> new RestaurantBranchNotFoundException("Restaurant branch not found"));


            order.setTable_no(request.getTable_no());
            order.setWaiter(request.getWaiter());
            order.setLiquor_ordered(request.isLiquor_ordered());
            order.setDissatisfied(request.isDissatisfied());
            order.setRestaurant_type(request.getRestaurant_type());
            order.setRestaurant(restaurant);
            order.setRestaurantBranch(restaurantBranch);

            double total = 0.0;

            Order savedOrder = orderRepository.save(order);

            for (OrderItemRequest dto : request.getItems()) {
                Dish dish = dishRepository.findById(dto.getDish_id())
                        .orElseThrow(() -> new DishNotFoundException("Dish not found"));

                OrderItems item = new OrderItems();

                item.setOrder(savedOrder);
                item.setDish(dish);
                item.setQuantity(dto.getQuantity());

                double price = dto.getQuantity() * dish.getPrice();

                item.setPrice(price);

                total = total + price;

                orderItemRepository.save(item);

            }

            if (order.getRestaurant_type().equalsIgnoreCase("LUXURY")) {
                total = total + 0.18 * total;
            } else if (order.getRestaurant_type().equalsIgnoreCase("NORMAL")) {
                total = total + 0.05 * total;
            }

            if (order.getLiquor_ordered()) {
                total = total + 0.05 * total;
            }

            if (order.getDissatisfied()) {
                total = total - total * 0.25;
            }

            savedOrder.setTotal(total);
            orderRepository.save(savedOrder);

            return "Order created successfully";
        }
        catch(Exception e)
        {
            throw new OrderProcessingException("failed to create order");
        }
    }

    public String cancelOrder(Integer orderId) {

        if (orderId == null) {
            throw new InvalidOrderException("Order ID cannot be null");
        }

        try {
            Order order = orderRepository.findById(orderId)
                    .orElseThrow(() -> new OrderNotFoundException("Order not found"));

            orderRepository.delete(order);

            return "Order has been cancelled successfully";
        }
        catch(Exception e)
        {
            throw new OrderProcessingException("failed to cancel the order");
        }
    }

    public String generateBill(Integer id) {
        if (id == null) {
            throw new InvalidOrderException("Order ID cannot be null");
        }

        try {
            Order order = orderRepository.findById(id)
                    .orElseThrow(() -> new OrderNotFoundException("Order not found"));

            return pdfService.generatePdf(order);
        } catch (Exception e) {
            throw new OrderProcessingException("failed to generate bill");
        }
    }
}
