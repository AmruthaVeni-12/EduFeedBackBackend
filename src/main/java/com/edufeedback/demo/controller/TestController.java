package com.edufeedback.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TestController {

    @GetMapping("/api/auth/test")
    public String publicTest() {
        return "Public API working";
    }

    @GetMapping("/api/secure/test")
    public String secureTest() {
        return "Secure API working";
    }
}