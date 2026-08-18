package com.kisan.service;

import com.kisan.dto.ProductRequestDTO;
import com.kisan.dto.ProductResponseDTO;
import com.kisan.mapper.ProductMapper;
import com.kisan.model.Product;
import com.kisan.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

   private final ProductRepository productRepository;
   private final ProductMapper productMapper;

   public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
       this.productRepository = productRepository;
       this.productMapper = productMapper;
   }

    public List<ProductResponseDTO> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return productMapper.toDtoList(allProducts);
    }

    public Optional<ProductResponseDTO> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(productMapper::toDto);
    }

    public ProductResponseDTO saveProduct(ProductRequestDTO request) {
        Product product =  productRepository.save(productMapper.toEntity(request));
        return productMapper.toDto(product);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }
}