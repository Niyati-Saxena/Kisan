package com.kisan.mapper;

import com.kisan.dto.RegistrationRequestDTO;
import com.kisan.model.Registration;
import org.springframework.stereotype.Component;

@Component
public class RegistrationMapper {
    public Registration toEntity(RegistrationRequestDTO request) {
        Registration registration = new Registration();

        registration.setName(request.name());
        registration.setEmail(request.email());
        registration.setLocation(request.location());

        return registration;
    }
}
