package com.kisan.dto;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponseDTO(
        int status,
        String message,
        LocalDateTime timeStamp,
        Map<String,String> errors
) {}