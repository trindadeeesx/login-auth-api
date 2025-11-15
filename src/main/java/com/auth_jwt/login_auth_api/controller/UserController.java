package com.auth_jwt.login_auth_api.controller;

import com.auth_jwt.login_auth_api.domain.user.User;
import com.auth_jwt.login_auth_api.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userRepo.findAll();
		return ResponseEntity.ok(users);
	}
}
