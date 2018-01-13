package com.fisiorctool.restController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fisiorctool.exceptions.UserExistException;
import com.fisiorctool.model.Actor;
import com.fisiorctool.model.User;
import com.fisiorctool.service.UserService;

@RestController
public class UserControllerRest {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "register")
	public ResponseEntity<Actor> register(@RequestBody User user, HttpServletRequest request) throws Exception {
		try {
			user = userService.register(user, request);
		} catch (UserExistException e) {
			throw new Exception(e.getMessage());
		}
		return new ResponseEntity<Actor>(HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "activeUser")
	public ResponseEntity activeUser(@RequestParam("token") String token){
		userService.activeUser(token);
		return new ResponseEntity(HttpStatus.OK);
	}

}
