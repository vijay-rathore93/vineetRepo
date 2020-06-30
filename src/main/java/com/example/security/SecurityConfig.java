/*
 * package com.example.security;
 * 
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * import lombok.RequiredArgsConstructor;
 * 
 * @Configuration
 * 
 * @RequiredArgsConstructor public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * private final PasswordEncoder passwordEncoder;
 * 
 * private final CustomUserDetailsService customUserDetailsService;
 * 
 * public void configure(AuthenticationManagerBuilder auth) throws Exception {
 * auth.userDetailsService(customUserDetailsService).passwordEncoder(
 * passwordEncoder); }
 * 
 * public void configure(HttpSecurity http) throws Exception {
 * http.csrf().disable();
 * http.authorizeRequests().antMatchers("/users/**").permitAll();
 * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and()
 * .httpBasic(); }
 * 
 * }
 */