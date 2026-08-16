package com.kisan.service;

import com.kisan.model.Product;
import com.kisan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(Long id) {
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Product does not exist"));
    }

    public Product saveProduct(Product product) {
        return repo.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        repo.delete(product);

    }
}