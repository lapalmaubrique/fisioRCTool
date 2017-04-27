package com.fisiorctool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisiorctool.model.UserToken;
import com.fisiorctool.repositories.IUserTokenRepository;

@Service
public class UserTokenServiceImpl implements UserTokenService {
	
	@Autowired
	private IUserTokenRepository userTokenRepository;

	@Override
	public UserToken save(UserToken userToken) {
		return userTokenRepository.save(userToken);
	}

	@Override
	public void delete(Integer id) {
		userTokenRepository.delete(id);
	}

	@Override
	public UserToken findByToken(UserToken userToken) {
		return userTokenRepository.findByToken(userToken.getToken());
	}

}
