package com.product.product.service.impl;

import com.product.product.entity.Product;
import com.product.product.repository.ProductRepository;
import com.product.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        Product productToUpdate = productRepository.findById(product.getId()).orElseThrow(EntityNotFoundException::new);
        productToUpdate.setTitle(product.getTitle());
        productToUpdate.setDescription(product.getDescription());
        return productRepository.save(productToUpdate);
    }
}
