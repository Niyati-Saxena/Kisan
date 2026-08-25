package com.kisan.dto;

import com.kisan.model.enums.Role;

public record LoginResponseDTO(
        String token,
        String tokenType,
        Long userId,
        String name,
        Role role
) {}
