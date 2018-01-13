package com.fisiorctool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fisiorctool.model.BasicData;

@Repository
public interface IBasicDataRepository extends JpaRepository<BasicData, Integer> {

}
