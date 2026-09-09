package com.kisan.service;

import com.kisan.dto.ProductRequestDTO;
import com.kisan.dto.ProductResponseDTO;
import com.kisan.exception.ResourceNotFoundException;
import com.kisan.mapper.ProductMapper;
import com.kisan.model.Product;
import com.kisan.model.User;
import com.kisan.repository.ProductRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.kisan.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        User vendor = (User) authentication.getPrincipal();

        Product product = productMapper.toEntity(request);

        product.setVendor(vendor);

        Product savedProduct = productRepository.save(product);

        return productMapper.toDto(savedProduct);
    }

    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO request) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        User vendor = (User) authentication.getPrincipal();

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        if (!product.getVendor().getId().equals(vendor.getId())) {
            throw new RuntimeException("You can update only your own products.");
        }

        product.setName(request.name());
        product.setCategory(request.category());
        product.setPrice(request.price());
        product.setLocation(request.location());
        product.setDescription(request.description());

        Product updatedProduct = productRepository.save(product);

        return productMapper.toDto(updatedProduct);
    }

    public void deleteProduct(Long id) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        User vendor = (User) authentication.getPrincipal();

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        if (!product.getVendor().getId().equals(vendor.getId())) {
            throw new RuntimeException("You can delete only your own products.");
        }

        productRepository.delete(product);
    }
}