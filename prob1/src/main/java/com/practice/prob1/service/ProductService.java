package com.practice.prob1.service;

import com.practice.prob1.dto.ProductCreate;
import com.practice.prob1.dto.ProductUpdate;
import com.practice.prob1.entity.Product;
import com.practice.prob1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Product createProduct(ProductCreate productCreate)
    {
        Product product = new Product();
        product.setName(productCreate.getName());
        product.setStock(productCreate.getStock());
        product.setPrice(productCreate.getPrice());

        return productRepository.save(product);
    }

    public Product updateProduct(Long userId ,ProductUpdate updatedProduct)
    {
        Product product = productRepository.findById(updatedProduct.getId())
                .orElseThrow(()-> new RuntimeException("Product not found"));

        product.setPrice(updatedProduct.getPrice());
        product.setStock(updatedProduct.getStock());

        return productRepository.save(product);
    }
}
