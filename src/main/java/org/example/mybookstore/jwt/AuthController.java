package org.example.mybookstore.jwt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/token")
    public ResponseEntity<Map<String, String>> generateToken(
            @RequestParam String email,
            @RequestParam String role) {
        // In real-world you’d validate user/role from DB
        String token = jwtService.generateToken(email, role);
        return ResponseEntity.ok(Map.of("access_token", token));
    }
}

