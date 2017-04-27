package com.fisiorctool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fisiorctool.model.UserToken;

@Repository
public interface IUserTokenRepository extends JpaRepository<UserToken, Integer> {
	
	@Query("SELECT ut FROM UserToken ut WHERE ut.token = :token")
	public UserToken findByToken(@Param("token") String token);
	

}
