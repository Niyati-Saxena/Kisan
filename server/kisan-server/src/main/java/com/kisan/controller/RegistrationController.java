// src/main/java/com/kisan/controller/RegistrationController.java
package com.kisan.controller;

import com.kisan.dto.RegistrationRequestDTO;
import com.kisan.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "*") // Allow frontend access
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody @Valid RegistrationRequestDTO registration) {
        registrationService.registerUser(registration);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registered successfully");
    }
}