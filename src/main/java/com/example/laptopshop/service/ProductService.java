package com.example.laptopshop.service;

import com.example.laptopshop.domain.Product;
import com.example.laptopshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    public ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getProduct() {
        return productRepository.findAll();
    }
}
