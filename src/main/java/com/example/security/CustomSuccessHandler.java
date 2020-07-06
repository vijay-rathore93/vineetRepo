package com.example.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String redirectUrl = "/userRoleBasedCall";
		Boolean adminExistsFlag = false;

		for (GrantedAuthority authority : authentication.getAuthorities()) {

			if (authority.getAuthority().equals("ROLE_ADMIN"))
				adminExistsFlag = true;
		}

		if (adminExistsFlag)
			redirectUrl = "/adminRoleBasedCall";

		redirectStrategy.sendRedirect(request, response, redirectUrl);

	}
}
