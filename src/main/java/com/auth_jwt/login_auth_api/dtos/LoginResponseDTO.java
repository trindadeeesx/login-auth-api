package com.auth_jwt.login_auth_api.dtos;

/**
 * LoginResponseDTO
 * DTO para resposta de login.
 *
 * @param name
 * @param token
 */
public record LoginResponseDTO (String name, String token) {}
