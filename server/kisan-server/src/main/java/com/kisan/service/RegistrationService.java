package com.kisan.service;

import com.kisan.dto.RegistrationRequestDTO;
import com.kisan.exception.DuplicateEmailException;
import com.kisan.mapper.RegistrationMapper;
import com.kisan.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final RegistrationMapper registrationMapper;

    public RegistrationService(RegistrationRepository registrationRepository, RegistrationMapper registrationMapper) {
        this.registrationRepository = registrationRepository;
        this.registrationMapper = registrationMapper;
    }

    public void registerUser(RegistrationRequestDTO registration) {
        if (registrationRepository.existsByEmail(registration.email())) {
            throw new DuplicateEmailException("Email already exists");
        }
        registrationRepository.save(registrationMapper.toEntity(registration));
    }
}
