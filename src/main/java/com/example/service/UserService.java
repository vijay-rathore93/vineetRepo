package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Entity.UserLoginInformation;
import com.example.repo.UserLoginRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserLoginRepo loginRepo;

	public UserLoginInformation saveUserInformation(UserLoginInformation userLoginInformation) {
		return loginRepo.save(userLoginInformation);
	}

	public List<UserLoginInformation> getAllUsers() {
		return loginRepo.findAll();
	}

	public UserLoginInformation getUser(Integer userId) {
		return loginRepo.findById(userId).get();
	}

	public void deleteuser(Integer userId) {
		loginRepo.deleteById(userId);
	}

}
