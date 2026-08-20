package com.kisan.mapper;

import com.kisan.dto.UserRequestDTO;
import com.kisan.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserRequestDTO request, String encodedPassword) {
        User user = new User();

        user.setName(request.name());
        user.setEmail(request.email());
        user.setLocation(request.location());
        user.setPassword(encodedPassword);
        user.setRole(request.role());

        return user;
    }
}
