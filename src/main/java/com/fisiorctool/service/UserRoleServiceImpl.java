package com.fisiorctool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisiorctool.model.UserRole;
import com.fisiorctool.repositories.IUserRoleRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	private IUserRoleRepository userRoleRepository;

	@Override
	public UserRole save(UserRole userRole) {
		userRole = userRoleRepository.save(userRole);
		return userRole;
	}

}
