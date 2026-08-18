package com.kisan.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DiseaseRequestDTO(
        @NotBlank
        @Size(min = 3, max =50)
        String name,
        @NotBlank
        @Size(min = 3 , max = 50)
        String symptoms,
        @NotBlank
        @Size(min = 3, max = 100)
        String treatment
) {
}
