package com.fisiorctool.service;

import java.util.List;

import com.fisiorctool.model.BasicData;

public interface BasicDataService {
	
	BasicData save(BasicData basicData);

	List<BasicData> findAll();

	BasicData findById(Integer id);

}
