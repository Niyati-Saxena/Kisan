package com.kisan.dto;

public record WeatherResponseDTO(
        double temperature,
        String condition,
        String name
) {
}
