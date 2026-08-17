package com.kisan.service;

import com.kisan.model.Registration;
import com.kisan.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public void registerUser(Registration registration) {
        Registration savedUser = registrationRepository.save(registration);
    }
}
