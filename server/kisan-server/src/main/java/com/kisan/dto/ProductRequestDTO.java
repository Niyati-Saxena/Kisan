package com.kisan.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRequestDTO(
        @NotBlank
        @Size(min = 3, max = 50)
        String name,
        @NotBlank
        String category,
        @Positive
        BigDecimal price,
        @NotBlank
        String location,
        @NotBlank
        String description
) {
}
