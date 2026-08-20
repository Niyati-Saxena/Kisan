package com.kisan.dto;

import com.kisan.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
        @NotBlank
        @Size(min = 3, max =50)
        String name,
        @Email
        @NotBlank
        String email,
        @NotBlank
        String location,
        @Size(min = 8, max = 100)
        @NotBlank
        String password,
        @NotNull
        Role role
) {
}
