package com.kisan.dto;

import java.util.List;

// it is not the DTO that your frontend receives. It is a Java representation of the JSON coming FROM the weather API.
public record WeatherApiResponseDTO(
        Main main,
        List<Weather> weather,
        String name
) {
    public record Main(double temp) {}

    public record Weather(String description) {}

}

