package com.kisan.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegistrationRequestDTO(
        @NotBlank
        @Size(min = 3, max =50)
        String name,
        @Email
        @NotBlank
        String email,
        @NotBlank
        String location
) {
}
