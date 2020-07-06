package com.example.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.Entity.UserLoginInformation;

public class SecurityUser implements UserDetails {
	private String userName;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	public SecurityUser(UserLoginInformation applicationUser, Collection<? extends GrantedAuthority> authorities) {
		this.userName = applicationUser.getUserName();
		this.password = applicationUser.getPassword();
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
