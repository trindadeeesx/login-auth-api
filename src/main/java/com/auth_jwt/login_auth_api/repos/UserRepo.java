package com.auth_jwt.login_auth_api.repos;

import com.auth_jwt.login_auth_api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositório para a entidade User.
 * Extende JpaRepository para fornecer operações CRUD.
 * @see User
 * @see JpaRepository
 */
public interface UserRepo extends JpaRepository<User, String> {
	/**
	 * Encontra um usuário pelo seu email.
	 *
	 * @param email O email do usuário.
	 * @return Um Optional contendo o usuário, se encontrado.
	 */
	Optional<User> findByEmail(String email);
}
