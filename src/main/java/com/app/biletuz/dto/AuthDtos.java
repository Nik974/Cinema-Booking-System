package com.app.biletuz.dto;

public class AuthDtos {


    public record RegisterRequest(
            String username,
            String email,
            String password
    ) {}


    public record LoginRequest(
            String username,
            String password
    ) {}


    public record AuthResponse(
            String message
    ) {}
}