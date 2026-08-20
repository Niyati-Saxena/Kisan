package com.kisan.config;

import com.kisan.model.User;
import com.kisan.model.enums.Role;
import com.kisan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminInitializer implements CommandLineRunner {
        private final PasswordEncoder passwordEncoder;
        private final UserRepository userRepository;

        public AdminInitializer(PasswordEncoder passwordEncoder , UserRepository userRepository){
            this.passwordEncoder = passwordEncoder;
            this.userRepository = userRepository;
        }

        @Value("${ADMIN_EMAIL}")
        private String adminEmail;
        @Value("${ADMIN_PASSWORD}")
        private String adminPassword;

        @Override
        public void run(String... args) {
            if (userRepository.existsByRole(Role.ADMIN)) {
                return;
            }

            User admin = new User();
            admin.setLocation("India");
            admin.setEmail(adminEmail);
            admin.setName("Kisan Admin");
            admin.setPassword(passwordEncoder.encode(adminPassword));
            admin.setRole(Role.ADMIN);

            userRepository.save(admin);

        }

}
