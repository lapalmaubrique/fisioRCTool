package com.fisiorctool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisiorctool.model.BasicData;
import com.fisiorctool.repositories.IBasicDataRepository;

@Service
public class BasicDataServiceImpl implements BasicDataService{
	
	@Autowired
	private IBasicDataRepository basicDataRepository;
	
	@Override
	public BasicData findById(Integer id) {
		return basicDataRepository.findOne(id);
	}

	@Override
	public List<BasicData> findAll() {
		return basicDataRepository.findAll();
	}

	@Override
	public BasicData save(BasicData basicData) {
		return basicDataRepository.save(basicData);
	}

}
