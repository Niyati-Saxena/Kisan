package com.kisan.dto;

import com.kisan.model.enums.Role;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        String location,
        Role role
) {
}
