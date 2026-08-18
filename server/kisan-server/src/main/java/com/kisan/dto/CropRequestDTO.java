package com.kisan.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CropRequestDTO(
        @NotBlank
        @Size(min = 3 , max= 50)
        String name,
        @NotBlank
        @Size(min = 3 , max= 50)
        String season,
        @NotBlank
        @Size(min = 3 , max= 50)
        String soilType,
        @NotBlank
        @Size(min = 3 , max= 50)
        String fertilizer,
        @NotBlank
        @Size(min = 3 , max= 50)
        String description
) {}
