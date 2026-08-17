package com.kisan.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SupplierRequestDTO(
        @NotBlank
        @Size(min = 3, max = 50)
        String name,
        @NotBlank
        @Size(max = 100)
        String location,
        @NotBlank
        @Size(min = 3 , max = 100)
        String speciality
) {
}
