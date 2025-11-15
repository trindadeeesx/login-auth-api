package com.auth_jwt.login_auth_api.infra.sec;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth_jwt.login_auth_api.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Serviço para geração e validação de tokens JWT.
 */
@Service
public class Token {

	@Value("${api.infra.sec.token.algorithm.secret}")
	private String algorithmSecret;

	/**
	 * Gera um token JWT para o usuário fornecido.
	 *
	 * @param user
	 * @return
	 */
	public String generateToken(User user) {
		try {
			// Configuração do algoritmo de assinatura
			Algorithm alg = Algorithm.HMAC256(algorithmSecret);

			// Criação do token JWT
			String token = JWT.create()
					.withIssuer("login-auth-api")
					.withSubject(user.getEmail())
					.withExpiresAt(generateExpirationDate())
					.sign(alg);

			return token;
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Erro ao gerar token jwt", exception);
		}
	}

	/**
	 * Valida o token JWT e retorna o assunto (subject) se válido.
	 *
	 * @param token
	 * @return
	 */
	public String validateToken(String token) {
		try {
			// Configuração do algoritmo de assinatura
			Algorithm alg = Algorithm.HMAC256(algorithmSecret);

			// Validação do token JWT
			return JWT.require(alg)
					.withIssuer("login-auth-api")
					.build()
					.verify(token)
					.getSubject();
		} catch (JWTVerificationException exception) {
			return null;
		}
	}

	/**
	 * Gera a data de expiração do token.
	 *
	 * @return
	 */
	private Instant generateExpirationDate() {
		// Token válido por 12 horas
		return LocalDateTime.now().plusHours(12).toInstant(ZoneOffset.of("-03:00")); // São Paulo
	}
}
