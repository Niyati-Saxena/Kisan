package com.kisan.controller;

import com.kisan.dto.NewsResponseDTO;
import com.kisan.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "http://localhost:3000")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<List<NewsResponseDTO>> getLiveNews() {
        return ResponseEntity.ok(newsService.getLiveNews());
    }
}