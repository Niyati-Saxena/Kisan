package com.kisan.dto;

public record NewsResponseDTO(
        String title,
        String summary,
        String link,
        String date
) {}
