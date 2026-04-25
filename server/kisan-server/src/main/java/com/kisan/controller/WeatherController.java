package com.kisan.controller;

import com.kisan.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "http://localhost:3000")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public ResponseEntity<String> getWeather(@PathVariable String city) {
        String response = weatherService.getWeatherByCity(city);
        return ResponseEntity.ok(response);
    }
}