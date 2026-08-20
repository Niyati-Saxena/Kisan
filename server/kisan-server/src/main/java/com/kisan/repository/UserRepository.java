package com.kisan.repository;

import com.kisan.model.User;
import com.kisan.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByRole(Role role);
}
