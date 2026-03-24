package com.pureskin.etudiant.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = {"https://pureskin-etudiant.vercel.app", "http://localhost:3000", "http://localhost:3001", "http://localhost:3002"}, allowedHeaders = "*")
public class RootController {
    
    @GetMapping("")
    public ResponseEntity<Map<String, Object>> root() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "running");
        response.put("application", "PureSkin Étudiant Backend");
        response.put("version", "1.0.0");
        response.put("message", "Backend API is operational");
        response.put("endpoints", Map.of(
            "health", "/actuator/health",
            "products", "/api/products",
            "blog", "/api/blog",
            "routines", "/api/routines",
            "testimonials", "/api/testimonials",
            "test", "/api/test"
        ));
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        response.put("message", "Backend is running");
        return ResponseEntity.ok(response);
    }
}
