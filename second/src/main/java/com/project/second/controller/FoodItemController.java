package com.project.second.controller;

import com.project.second.dtos.FoodItemRequest;
import com.project.second.service.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foods")
@RequiredArgsConstructor
public class FoodItemController {

    private final FoodItemService foodItemService;

    @PostMapping("/request")
    public String purchaseFood(@RequestBody FoodItemRequest request)
    {
        return foodItemService.purchaseFood(request);
    }

    @PostMapping("/request/approve/{food_id}")
    public String approvePurchase(@PathVariable Integer food_id)
    {
        return foodItemService.approvePurchase(food_id);
    }

    @PostMapping("/request/reject/{food_id}")
    public String rejectPurchase(@PathVariable Integer food_id)
    {
        return foodItemService.rejectPurchase(food_id);
    }


}
