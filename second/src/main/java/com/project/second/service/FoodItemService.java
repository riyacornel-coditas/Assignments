package com.project.second.service;

import com.project.second.dtos.FoodItemRequest;
import com.project.second.entity.*;
import com.project.second.exception.*;
import com.project.second.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;
    private final ChefRepository chefRepository;
    private final ManagerRepository managerRepository;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantBranchRepository restaurantBranchRepository;

    public String purchaseFood(FoodItemRequest request)
    {
        if (request == null) {
            throw new InvalidFoodRequestException("Food request cannot be null");
        }

        if (request.getItem_name() == null) {
            throw new InvalidFoodRequestException("Item name is required");
        }

        if (request.getCost() <= 0) {
            throw new InvalidFoodRequestException("Cost must be greater than 0");
        }

        if (request.getQuantity() <= 0) {
            throw new InvalidFoodRequestException("Quantity must be greater than 0");
        }
        if (request.getRestaurant_id() == null) {
            throw new InvalidFoodRequestException("Restaurant id is required");
        }
        if (request.getBranch_id() == null) {
            throw new InvalidFoodRequestException("Branch id is required");
        }


        Chef chef = chefRepository.findById(request.getChef_id())
                .orElseThrow(()-> new ChefNotFoundException("Chef not found"));

        Manager manager = managerRepository.findById(request.getManager_id())
                .orElseThrow(()-> new ManagerNotFoundException("Manager not found"));

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurant_id())
                .orElseThrow(()-> new RestaurantNotFoundException("Restaurant not found"));

        RestaurantBranch restaurantBranch = restaurantBranchRepository.findById(request.getBranch_id())
                .orElseThrow(()-> new RestaurantBranchNotFoundException("Restaurant Branch not found"));

        try {
            FoodItem foodItem = new FoodItem();

            foodItem.setItem_name(request.getItem_name());
            foodItem.setCost(request.getCost());
            foodItem.setQuantity(request.getQuantity());
            foodItem.setStatus("PENDING");
            foodItem.setChef(chef);
            foodItem.setManager(manager);
            foodItem.setRestaurant(restaurant);
            foodItem.setRestaurantBranch(restaurantBranch);

            foodItemRepository.save(foodItem);

            return "Food item requested";
        } catch (Exception e) {
            throw new FoodPurchaseException("Failed to request food item");
        }
    }


    public String approvePurchase(Integer foodId) {

        if (foodId == null) {
            throw new InvalidFoodRequestException("Food ID cannot be null");
        }

        try {
            FoodItem foodItem = foodItemRepository.findById(foodId)
                    .orElseThrow(() -> new FoodItemNotFoundException("Food item not found"));

            foodItem.setStatus("APPROVED");

            foodItemRepository.save(foodItem);

            return "Food item has been approved";
        } catch (Exception e) {
            throw new FoodPurchaseException("Failed to approve food item");
        }

    }

    public String rejectPurchase(Integer foodId) {

        if (foodId == null) {
            throw new InvalidFoodRequestException("Food ID cannot be null");
        }

        try {
            FoodItem foodItem = foodItemRepository.findById(foodId)
                    .orElseThrow(() -> new FoodItemNotFoundException("Food item not found"));

            foodItem.setStatus("REJECTED");

            foodItemRepository.save(foodItem);

            return "Food item has been rejected";
        } catch (Exception e) {
            throw new FoodPurchaseException("Failed to reject food item");
        }
    }
}
