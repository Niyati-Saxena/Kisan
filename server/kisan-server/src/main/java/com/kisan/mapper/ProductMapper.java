package com.kisan.mapper;

import com.kisan.dto.ProductRequestDTO;
import com.kisan.dto.ProductResponseDTO;
import com.kisan.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {
    public Product toEntity(ProductRequestDTO request) {
        Product product = new Product();

        product.setCategory(request.category());
        product.setDescription(request.description());
        product.setName(request.name());
        product.setPrice(request.price());
        product.setLocation(request.location());

        return product;
    }

    public ProductResponseDTO toDto(Product request) {
        return new ProductResponseDTO(request.getName() , request.getCategory(), request.getPrice(), request.getLocation(), request.getDescription());
    }

    public List<ProductResponseDTO> toDtoList(List<Product> request) {
        return request.stream().map(this::toDto).toList();
    }
}
