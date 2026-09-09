package com.kisan.dto;

import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        String name,
        String category,
        BigDecimal price,
        String location,
        String description,
        Long vendorId
) {
}