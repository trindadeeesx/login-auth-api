package com.auth_jwt.login_auth_api.dtos;

/**
 * RegisterRequestDTO
 * DTO para requisição de registro.
 *
 * @param name
 * @param email
 * @param password
 */
public record RegisterRequestDTO(String name, String email, String password) { }
