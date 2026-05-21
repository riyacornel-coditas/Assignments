package com.project.second.service;

import com.project.second.dtos.DishRequest;
import com.project.second.entity.Dish;
import com.project.second.entity.Restaurant;
import com.project.second.exception.DishSaveException;
import com.project.second.exception.InvalidDishDataException;
import com.project.second.exception.RestaurantNotFoundException;
import com.project.second.repository.DishRepository;
import com.project.second.repository.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepo;

    private final RestaurantRepository restaurantRepository;

    public String addDish(DishRequest request) {

        if(request==null)
        {
            throw new InvalidDishDataException("Dish request cannot be null");
        }

        if(request.getDish_name() == null)
        {
            throw new InvalidDishDataException("dish name is required");
        }

        if(request.getPrice() <= 0)
        {
            throw new InvalidDishDataException("price must be greater than zero");
        }


        try {
            Dish d = new Dish();

            Restaurant restaurant = restaurantRepository.findById(request.getRestaurant_id())
                    .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));

            d.setDish_name(request.getDish_name());
            d.setDescription(request.getDescription());
            d.setPrice(request.getPrice());
            d.setType(request.getType());
            d.setRestaurant(restaurant);

            dishRepo.save(d);

            return "Dish added successfully";
        } catch (Exception e) {
            throw new DishSaveException("failed to save dish");
        }

    }
}
