package com.imdbclone.controller;

import com.imdbclone.config.jwt.JwtService;
import com.imdbclone.dto.AuthRequest;
import com.imdbclone.dto.AuthResponse;
import com.imdbclone.model.User;
import com.imdbclone.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            
            User user = (User) authentication.getPrincipal();
            String token = jwtService.generateToken(user);
            
            return ResponseEntity.ok(new AuthResponse(token, user.getUsername()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AuthResponse("Invalid credentials"));
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody User user) {
        try {
            User savedUser = userService.createUser(user);
            String token = jwtService.generateToken(savedUser);
            
            return ResponseEntity.ok(new AuthResponse(token, savedUser.getUsername()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AuthResponse(e.getMessage()));
        }
    }
    
    @GetMapping("/validate")
    public ResponseEntity<AuthResponse> validateToken(@RequestHeader("Authorization") String token) {
        try {
            if (token != null && token.startsWith("Bearer ")) {
                String jwt = token.substring(7);
                // TODO: Implementar validação do token
                return ResponseEntity.ok(new AuthResponse("Token is valid"));
            }
            return ResponseEntity.badRequest().body(new AuthResponse("Invalid token"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AuthResponse("Token validation failed"));
        }
    }
} 