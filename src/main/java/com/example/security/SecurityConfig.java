
package com.example.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;

	private final CustomUserDetailsService customUserDetailsService;

	private final CustomSuccessHandler customSuccessHandler;

	private final CustomExceptionHandler authenticationFailureHandler;

	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
	}

	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/users/**").permitAll();
		http.authorizeRequests().antMatchers("/errorPage/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/users/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN").anyRequest().authenticated().and()
				.formLogin()/* .defaultSuccessUrl("/commonPage", true) */
				.loginPage("/login").usernameParameter("username1").passwordParameter("password1").permitAll()
				.successHandler(customSuccessHandler)
				// .failureForwardUrl("/login?error").permitAll()
				.failureHandler(authenticationFailureHandler).and().httpBasic().and().logout()
				.deleteCookies("JSESSIONID").logoutSuccessUrl("/login?logout").permitAll();
	}

}
