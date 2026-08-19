package com.kisan.service;

import com.kisan.dto.ProductRequestDTO;
import com.kisan.dto.ProductResponseDTO;
import com.kisan.exception.ResourceNotFoundException;
import com.kisan.mapper.ProductMapper;
import com.kisan.model.Product;
import com.kisan.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product does not exist."));
        return productMapper.toDto(product);
    }

    public ProductResponseDTO saveProduct(ProductRequestDTO request) {
        Product product =  productRepository.save(productMapper.toEntity(request));
        return productMapper.toDto(product);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepository.delete(product);
    }
}