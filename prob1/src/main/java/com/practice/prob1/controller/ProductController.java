package com.practice.prob1.controller;

import com.practice.prob1.dto.ProductCreate;
import com.practice.prob1.dto.ProductUpdate;
import com.practice.prob1.entity.Product;
import com.practice.prob1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody ProductCreate product)
    {
        return productService.createProduct(product);
    }

    @PostMapping("/update")
    public Product updateProduct(@RequestParam Long userId, @RequestBody ProductUpdate product)
    {
        return productService.updateProduct(userId, product);
    }
}
