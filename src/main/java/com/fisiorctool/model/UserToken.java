package com.fisiorctool.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_token_activate")
public class UserToken implements Serializable {

	private static final long serialVersionUID = 3868269731826822792L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "token")
	private String token;

	@Column(name = "user_id")
	private Integer userId;
	
	public UserToken() {
	}

	public UserToken(String token) {
		super();
		this.token = token;
	}

	public UserToken(String token, Integer userId) {
		super();
		this.token = token;
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
