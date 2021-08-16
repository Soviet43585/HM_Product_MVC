package com.product.product.service;

import com.product.product.entity.Product;
import com.product.product.repository.ProductRepository;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer id);
    void deleteById(Integer id);
    void create(Product product);
    Product update(Product product);
}
