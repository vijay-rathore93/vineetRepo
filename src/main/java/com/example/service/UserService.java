package com.example.service;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Entity.UserLoginInformation;
import com.example.repo.UserLoginRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserLoginRepo loginRepo;

	private final PasswordEncoder passwordEncoder;

	public UserLoginInformation saveUserInformation(UserLoginInformation userLoginInformation) {
		userLoginInformation.setPassword(passwordEncoder.encode(userLoginInformation.getPassword()));
		return loginRepo.save(userLoginInformation);
	}

	public List<UserLoginInformation> getAllUsers() {
		return loginRepo.findAll();
	}

	public UserLoginInformation getUser(Integer userId) {

		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		UserLoginInformation userLoginInformation = loginRepo.findByUserName(userName);

		if (userLoginInformation.getUserId() == userId)
			return loginRepo.findById(userId).get();
		else
			throw new RuntimeException("Not Allowed");
	}

	public void deleteuser(Integer userId) {
		loginRepo.deleteById(userId);
	}

}
