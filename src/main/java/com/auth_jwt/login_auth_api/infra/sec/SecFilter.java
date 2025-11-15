package com.auth_jwt.login_auth_api.infra.sec;

import com.auth_jwt.login_auth_api.domain.user.User;
import com.auth_jwt.login_auth_api.repos.UserRepo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

/**
 * Filtro de segurança para validar o token JWT em cada requisição.
 */
@Component
public class SecFilter extends OncePerRequestFilter {
	@Autowired
	Token tokenService;

	@Autowired
	UserRepo userRepo;

	/**
	 * Faz a filtragem de cada requisição para validar o token JWT.
	 *
	 * @param request
	 * @param response
	 * @param filterChain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request,
	                                HttpServletResponse response,
	                                FilterChain filterChain)
			throws IOException, ServletException {

		var token = this.recoverToken(request);
		var isValid = tokenService.validateToken(token);

		if (isValid != null) {
			User user = userRepo.findByEmail(isValid).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
			var authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
			var authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}

		filterChain.doFilter(request, response);
	}

	/**
	 * Recupera o token JWT do cabeçalho da requisição.
	 *
	 * @param request
	 * @return
	 */
	private String recoverToken(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization");
		if (authHeader == null) return null;
		return authHeader.replace("Bearer ", "");
	}
}
