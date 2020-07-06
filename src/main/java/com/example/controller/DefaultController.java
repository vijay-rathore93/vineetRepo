package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

	@GetMapping("/commonPage")
	public String getCommonPage() {
		return "common";
	}

	@GetMapping("/userRoleBasedCall")
	public String getUserPage() {
		return "user";
	}

	@GetMapping("/adminRoleBasedCall")
	public String getAdminPage() {
		return "admin";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@GetMapping("/errorPage")
	public String getError() {
		return "error";
	}

}
