package com.kisan.service;
import com.kisan.dto.WeatherApiResponseDTO;
import com.kisan.dto.WeatherResponseDTO;
import com.kisan.mapper.WeatherMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final WeatherMapper weatherMapper;

    public WeatherService(WeatherMapper weatherMapper) {
        this.weatherMapper = weatherMapper;
    }

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    public WeatherResponseDTO getWeatherByCity(String city) {
        String url = apiUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric";
        RestTemplate restTemplate = new RestTemplate();
        WeatherApiResponseDTO response = restTemplate.getForObject(url, WeatherApiResponseDTO.class);
        return weatherMapper.toDto(response);
    }
}