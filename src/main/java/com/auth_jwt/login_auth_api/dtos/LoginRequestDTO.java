package com.auth_jwt.login_auth_api.dtos;

/**
 * LoginRequestDTO
 * DTO para requisição de login.
 *
 * @param email
 * @param password
 */
public record LoginRequestDTO(String email, String password) {}
