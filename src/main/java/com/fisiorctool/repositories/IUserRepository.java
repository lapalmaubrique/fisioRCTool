package com.fisiorctool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fisiorctool.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User findByEmail(String email);

}
