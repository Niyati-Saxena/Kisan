package com.kisan.dto;

import jakarta.validation.constraints.NotBlank;

public record TransporterRequestDTO(
        @NotBlank
        String name,
        @NotBlank
        String vehicleType,
        @NotBlank
        String route
) {
}
