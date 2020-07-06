package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.UserLoginInformation;

public interface UserLoginRepo extends JpaRepository<UserLoginInformation, Integer>{

	UserLoginInformation findByUserName(String username);

}
