package com.kisan.mapper;

import com.kisan.dto.WeatherApiResponseDTO;
import com.kisan.dto.WeatherResponseDTO;
import org.springframework.stereotype.Component;

@Component
//Take the external API DTO and convert it into the DTO that your Kisan frontend should receive.
public class WeatherMapper {

    public WeatherResponseDTO toDto(WeatherApiResponseDTO request) {
        return new WeatherResponseDTO(request.main().temp() , request.weather().get(0).description() , request.name());
    }

}
