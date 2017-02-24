package com.fisiorctool.service;

import java.util.List;

import com.fisiorctool.model.Actor;

public interface ActorService {
	
	Actor findById(Integer id);
	
	List<Actor> findAll();
	
	Actor save(Actor actor);
	
	Actor update(Actor actor);
	
	void delete(Integer id);

}
