package com.kisan.controller;

import com.kisan.dto.WeatherResponseDTO;
import com.kisan.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "http://localhost:3000")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<WeatherResponseDTO> getWeather(@PathVariable String city) {
        WeatherResponseDTO response = weatherService.getWeatherByCity(city);
        return ResponseEntity.ok(response);
    }
}