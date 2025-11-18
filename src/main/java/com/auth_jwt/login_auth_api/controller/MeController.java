package com.auth_jwt.login_auth_api.controller;

import com.auth_jwt.login_auth_api.domain.user.User;
import com.auth_jwt.login_auth_api.dtos.MeResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/me")
public class MeController {
	@GetMapping
	public ResponseEntity<MeResponseDTO> getMe(@AuthenticationPrincipal User user) {
		return ResponseEntity.ok(
				new MeResponseDTO(user.getName(), user.getEmail())
		);
	}
}
