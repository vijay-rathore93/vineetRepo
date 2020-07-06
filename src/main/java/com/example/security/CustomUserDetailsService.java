
package com.example.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Entity.Role;
import com.example.Entity.UserLoginInformation;
import com.example.repo.UserLoginRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserLoginRepo userLoginRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLoginInformation applicationUser = userLoginRepo.findByUserName(username);
		return new SecurityUser(applicationUser, getAuthorities(applicationUser));
	}

	public Set<SimpleGrantedAuthority> getAuthorities(UserLoginInformation applicationUser) {
		HashSet<SimpleGrantedAuthority> hs = new HashSet<SimpleGrantedAuthority>();
		for (Role role : applicationUser.getRoleList()) {
			hs.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		}
		return hs;
	}

}
