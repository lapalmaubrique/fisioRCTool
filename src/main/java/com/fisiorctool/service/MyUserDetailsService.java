package com.fisiorctool.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fisiorctool.model.UserRole;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(final String username) {
		com.fisiorctool.model.User user = userService.findByEmail(username);
		if(user != null){
			if(!user.isEnabled()){
				throw new DisabledException("El usuario no está activo");
			}
			List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
			return buildUserForAuthentication(user, authorities); 
		} else {
		    throw new UsernameNotFoundException("Usuario no registrado");
		}
	}
	
	// Converts User to  org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.fisiorctool.model.User user, List<GrantedAuthority> authorities) {
		return new User(user.getEmail(), user.getPassword(),
			user.isEnabled(), true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}

}
