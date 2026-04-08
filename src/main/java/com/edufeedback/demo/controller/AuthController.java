package com.edufeedback.demo.controller;

import com.edufeedback.demo.model.AdminUser;
import com.edufeedback.demo.model.AuthResponse;
import com.edufeedback.demo.service.AuthService;
import com.edufeedback.demo.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AdminUser adminUser) {
        AdminUser saved = authService.register(adminUser);
        String token = jwtUtil.generateToken(saved);
        return ResponseEntity.ok(new AuthResponse(saved.getId(), saved.getUsername(), saved.getEmail(), token));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AdminUser adminUser) {
        AdminUser existing = authService.login(adminUser);
        String token = jwtUtil.generateToken(existing);
        return ResponseEntity.ok(new AuthResponse(existing.getId(), existing.getUsername(), existing.getEmail(), token));
    }
}