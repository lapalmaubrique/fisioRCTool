package com.fisiorctool.service;

import javax.servlet.http.HttpServletRequest;

import com.fisiorctool.exceptions.UserExistException;
import com.fisiorctool.model.User;

public interface UserService {
	
	User register(User user, HttpServletRequest request) throws UserExistException;
	
	User findByEmail(String email);

	void activeUser(String token);

}
