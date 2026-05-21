package com.project.second.controller;

import com.project.second.dtos.DishRequest;
import com.project.second.repository.DishRepository;
import com.project.second.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;

    @PostMapping("/add")
    public String addDish(@RequestBody DishRequest request)
    {
        return dishService.addDish(request);
    }
}
