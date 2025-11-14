package com.app.biletuz.controller;

import com.app.biletuz.dto.AuthDtos;
import com.app.biletuz.dto.JwtResponse;
import com.app.biletuz.service.AuthService;
import com.app.biletuz.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @PostMapping("/register")
    public ResponseEntity<AuthDtos.AuthResponse> register(
            @RequestBody AuthDtos.RegisterRequest request
    ) {
        authService.register(request);
        return ResponseEntity.ok(new AuthDtos.AuthResponse("User registered successfully!"));
    }


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(
            @RequestBody AuthDtos.LoginRequest request
    ) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String jwtToken = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(jwtToken));
    }
}