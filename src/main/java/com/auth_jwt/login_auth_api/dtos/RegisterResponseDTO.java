package com.auth_jwt.login_auth_api.dtos;

/**
 * RegisterResponseDTO
 * DTO para resposta de registro.
 *
 * @param name
 * @param email
 * @param token
 */
public record RegisterResponseDTO(String name, String email, String token) {}
