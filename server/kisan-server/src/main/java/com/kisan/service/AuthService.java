package com.kisan.service;

import com.kisan.dto.LoginRequestDTO;
import com.kisan.dto.LoginResponseDTO;
import com.kisan.dto.UserRequestDTO;
import com.kisan.exception.DuplicateEmailException;
import com.kisan.exception.InvalidCredentailsException;
import com.kisan.exception.InvalidRoleException;
import com.kisan.mapper.UserMapper;
import com.kisan.model.User;
import com.kisan.model.enums.Role;
import com.kisan.repository.UserRepository;
import com.kisan.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            UserMapper userMapper,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void registerUser(UserRequestDTO registration) {

        if (userRepository.existsByEmail(registration.email())) {
            throw new DuplicateEmailException("Email already exists");
        }

        validateRegistrationRole(registration.role());

        String encodedPassword =
                passwordEncoder.encode(registration.password());

        User user = userMapper.toEntity(
                registration,
                encodedPassword
        );

        userRepository.save(user);
    }

    private void validateRegistrationRole(Role role) {

        if (role == null) {
            throw new InvalidRoleException("Role is required.");
        }

        if (role == Role.ADMIN) {
            throw new InvalidRoleException(
                    "Admin registration is not allowed"
            );
        }
    }

    public LoginResponseDTO loginUser(LoginRequestDTO loginRequest) {

        User user = userRepository.findByEmail(loginRequest.email())
                .orElseThrow(() ->
                        new InvalidCredentailsException(
                                "Invalid email or password"
                        )
                );

        if (!passwordEncoder.matches(
                loginRequest.password(),
                user.getPassword()
        )) {
            throw new InvalidCredentailsException(
                    "Invalid email or password"
            );
        }

        // Generate JWT after successful authentication
        String token = jwtService.generateToken(user);

        return new LoginResponseDTO(
                token,
                "Bearer",
                user.getId(),
                user.getName(),
                user.getRole()
        );
    }
}