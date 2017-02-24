package com.example.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.AngularMvcApplication;
import com.example.model.Actor;
import com.example.repositories.IActorRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AngularMvcApplication.class})
@Transactional
public class IActorRepositoryTest {
	
	@Autowired
	private IActorRepository actorRepository;
	
	@Test
	public void findAll(){
		List<Actor> list = actorRepository.findAll();
		Assert.assertTrue(list != null && list.size() > 0);
	}
	
	@Test
	public void save(){
		Actor actor = new Actor();
		actor.setFirstName("MANUELJESUS");
		actor.setLastName("SPAIN");
		actor.setLastUpdate(new Date());
		actor = actorRepository.save(actor);
		Assert.assertNotNull(actor.getId());
	}
	
	@Test
	public void update(){
		Actor actor = new Actor();
		actor.setId(1);
		actor.setFirstName("MANUELJESUS");
		actor.setLastName("SPAIN");
		actor.setLastUpdate(new Date());
		actor = actorRepository.save(actor);
		Assert.assertTrue(actor.getFirstName().equals("MANUELJESUS"));
	}
	
	@Test
	public void delete(){
		actorRepository.delete(1);
		Assert.assertNull(actorRepository.findOne(1));
	}

}
