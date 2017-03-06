package com.fisiorctool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fisiorctool.model.UserRole;

@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole, Integer> {
	

}
