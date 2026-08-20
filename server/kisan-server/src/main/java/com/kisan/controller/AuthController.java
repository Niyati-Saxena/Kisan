// src/main/java/com/kisan/controller/RegistrationController.java
package com.kisan.controller;

import com.kisan.dto.UserRequestDTO;
import com.kisan.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "*") // Allow frontend access
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRequestDTO request) {
        authService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registered successfully");
    }
}