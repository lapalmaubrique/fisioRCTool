package com.fisiorctool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fisiorctool.model.Actor;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {

}
