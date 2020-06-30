package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.UserLoginInformation;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/users")
	public UserLoginInformation saveUser(@RequestBody UserLoginInformation userLoginInformation) {
		return userService.saveUserInformation(userLoginInformation);
	}

	@GetMapping("/users")
	public List<UserLoginInformation> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/{userId}")
	public UserLoginInformation getUser(@PathVariable Integer userId) {
		return userService.getUser(userId);
	}

	@DeleteMapping("/users/{userId}")
	public void deleteuser(@PathVariable Integer userId) {
		userService.deleteuser(userId);
	}

}
