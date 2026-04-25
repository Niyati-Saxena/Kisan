// src/main/java/com/kisan/controller/RegistrationController.java
package com.kisan.controller;

import com.kisan.model.Registration;
import com.kisan.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "*") // Allow frontend access
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @PostMapping
    public String registerUser(@RequestBody Registration registration) {
        registrationRepository.save(registration);
        return "Registered successfully!";
    }
}