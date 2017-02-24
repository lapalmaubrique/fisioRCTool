package com.fisiorctool.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fisiorctool.AngularMvcApplication;
import com.fisiorctool.model.Actor;
import com.fisiorctool.service.ActorServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AngularMvcApplication.class})
@Transactional
public class ActorServiceImplTest {
	
	@Autowired
	private ActorServiceImpl actorService;
	
	@Test
	public void findById(){
		Actor actor = actorService.findById(1);
		Assert.assertNotNull(actor);
	}
	
	@Test
	public void findAll(){
		List<Actor> list = actorService.findAll();
		Assert.assertTrue(list != null && list.size() > 0);
	}
	
	@Test
	public void save(){
		Actor actor = new Actor();
		actor.setFirstName("MANUELJESUS");
		actor.setLastName("SPAIN");
		actor.setLastUpdate(new Date());
		actor = actorService.save(actor);
		Assert.assertNotNull(actor.getId());
	}
	
	@Test
	public void update(){
		Actor actor = new Actor();
		actor.setId(1);
		actor.setFirstName("MANUELJESUS");
		actor.setLastName("SPAIN");
		actor.setLastUpdate(new Date());
		actor = actorService.save(actor);
		Assert.assertTrue(actor.getFirstName().equals("MANUELJESUS"));
	}
	
	@Test
	public void delete(){
		actorService.delete(1);
		Assert.assertNull(actorService.findById(1));
	}

}
