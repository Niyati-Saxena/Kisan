// src/main/java/com/kisan/controller/RegistrationController.java
package com.kisan.controller;

import com.kisan.dto.LoginRequestDTO;
import com.kisan.dto.LoginResponseDTO;
import com.kisan.dto.UserRequestDTO;
import com.kisan.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allow frontend access
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRequestDTO request) {
        authService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody @Valid LoginRequestDTO request) {
        LoginResponseDTO response = authService.loginUser(request);
        return ResponseEntity.ok(response);
    }
}