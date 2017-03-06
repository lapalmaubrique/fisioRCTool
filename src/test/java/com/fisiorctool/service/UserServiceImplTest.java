package com.fisiorctool.service;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fisiorctool.FisioRCToolApplication;
import com.fisiorctool.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FisioRCToolApplication.class})
@Transactional
public class UserServiceImplTest {
	
	@Autowired
	private UserServiceImpl userService;
	
	@Test
	@Ignore
	public void findByEmail(){
		User user = userService.findByEmail("prueba@gmail.com");
		Assert.assertNotNull(user);
	}
	
	@Test
	public void save(){
//		User user = new User();
//		user.setEmail("prueba@gmail.com");
//		user.setFullName("fullName");
//		user.setPassword("password");
//		user.setEnabled(true);
//		user.setRegistrationDate(new Date());
//		user = userService.save(user);
//		Assert.assertNotNull(user.getId());
	}

}
