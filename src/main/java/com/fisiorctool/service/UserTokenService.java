package com.fisiorctool.service;

import com.fisiorctool.model.UserToken;

public interface UserTokenService {
	
	UserToken save(UserToken userToken);
	
	void delete(Integer id);
	
	UserToken findByToken(UserToken userToken);
	
}
