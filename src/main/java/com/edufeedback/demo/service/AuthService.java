package com.edufeedback.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edufeedback.demo.model.AdminUser;
import com.edufeedback.demo.repository.AdminUserRepository;

import java.util.Optional;

@Service
public class AuthService {

    private final AdminUserRepository adminUserRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor Injection
    public AuthService(AdminUserRepository adminUserRepository,
                       PasswordEncoder passwordEncoder) {
        this.adminUserRepository = adminUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // REGISTER
    public AdminUser register(AdminUser adminUser) {

        Optional<AdminUser> existingUser =
                adminUserRepository.findByUsername(adminUser.getUsername());

        if (existingUser.isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        adminUser.setPassword(passwordEncoder.encode(adminUser.getPassword()));

        return adminUserRepository.save(adminUser);
    }

    // LOGIN
    public AdminUser login(AdminUser adminUser) {

        Optional<AdminUser> optionalUser =
                adminUserRepository.findByUsername(adminUser.getUsername());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        AdminUser existing = optionalUser.get();

        if (!passwordEncoder.matches(adminUser.getPassword(), existing.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        } 

        return existing;
    }
}