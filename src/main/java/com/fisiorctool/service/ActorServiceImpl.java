package com.fisiorctool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisiorctool.model.Actor;
import com.fisiorctool.repositories.IActorRepository;

@Service
public class ActorServiceImpl implements ActorService{
	
	@Autowired
	private IActorRepository actorRepository;
	
	@Override
	public Actor findById(Integer id) {
		return actorRepository.findOne(id);
	}

	@Override
	public List<Actor> findAll() {
		return actorRepository.findAll();
	}

	@Override
	public Actor save(Actor actor) {
		return actorRepository.save(actor);
	}

	@Override
	public Actor update(Actor actor) {
		return actorRepository.save(actor);
	}

	@Override
	public void delete(Integer id) {
		actorRepository.delete(id);
	}


}
