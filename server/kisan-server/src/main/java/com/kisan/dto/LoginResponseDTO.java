package com.kisan.dto;

public record LoginResponseDTO(
        String token,
        String tokenType,
        Long userId,
        String name,
        String role
) {}
