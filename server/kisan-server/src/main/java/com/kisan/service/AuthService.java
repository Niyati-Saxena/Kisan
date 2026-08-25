package com.kisan.service;

import com.kisan.dto.LoginRequestDTO;
import com.kisan.dto.LoginResponseDTO;
import com.kisan.dto.UserRequestDTO;
import com.kisan.dto.UserResponseDTO;
import com.kisan.exception.DuplicateEmailException;
import com.kisan.exception.InvalidCredentailsException;
import com.kisan.exception.InvalidRoleException;
import com.kisan.mapper.UserMapper;
import com.kisan.model.User;
import com.kisan.model.enums.Role;
import com.kisan.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserRequestDTO registration) {
        // check duplicate email
        if (userRepository.existsByEmail(registration.email())) {
            throw new DuplicateEmailException("Email already exists");
        }
        // validate role
        validateRegistrationRole(registration.role());
        // encode password
        String encodedPassword = passwordEncoder.encode(registration.password());
        // map dto -> user
        User user = userMapper.toEntity(registration, encodedPassword);
        // save into db
        userRepository.save(user);
    }

    // helper method to make sure only farmers and vendors will be allowed
    // and admin will not be able to be registered
    private void validateRegistrationRole(Role role) {
        if (role == null) {
            throw new InvalidRoleException("Role is required.");
        }

        if (role == Role.ADMIN) {
            throw new InvalidRoleException("Admin registration is not allowed");
        }
    }

    public LoginResponseDTO loginUser(LoginRequestDTO loginReques) {
        // finding the user by email
        User user = userRepository.findByEmail(loginReques.email())
                .orElseThrow(() -> new InvalidCredentailsException("Invlaid email or password"));

        // verifying the BCrypt password
        if (!passwordEncoder.matches(loginReques.password() , user.getPassword())) {
            throw new InvalidCredentailsException("Invalid email or password");
        }

        // return user info for valid users
        return new LoginResponseDTO(
                null,
                "Bearer",
                user.getId(),
                user.getName(),
                user.getRole()
        );
    }
}
