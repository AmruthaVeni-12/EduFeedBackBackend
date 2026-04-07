package com.edufeedback.demo.controller;

import com.edufeedback.demo.model.AdminUser;
import com.edufeedback.demo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AdminUser> register(@RequestBody AdminUser adminUser) {
        return ResponseEntity.ok(authService.register(adminUser));
    }

    @PostMapping("/login")
    public ResponseEntity<AdminUser> login(@RequestBody AdminUser adminUser) {
        return ResponseEntity.ok(authService.login(adminUser));
    }
}