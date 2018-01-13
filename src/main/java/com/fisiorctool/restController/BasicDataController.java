package com.fisiorctool.restController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisiorctool.dto.BasicDataDTO;
import com.fisiorctool.model.BasicData;
import com.fisiorctool.service.BasicDataService;

@RestController
@RequestMapping(value = "/basicData/")
public class BasicDataController {
	
	@Autowired
	private BasicDataService basicDataService;
	
	@GetMapping(value = "findById/{id}")
	public BasicDataDTO findById(@PathVariable Integer id){
		return convertToDTO(basicDataService.findById(id));
	}
	
	@GetMapping(value = "findAll")
	public List<BasicDataDTO> findAll(){
		List<BasicDataDTO> listDTO = new ArrayList<BasicDataDTO>();
		List<BasicData> list = basicDataService.findAll();
		for (BasicData basicData : list) {
			listDTO.add(convertToDTO(basicData));
		}
		return listDTO;
	}
	
	@PostMapping(value = "save")
	public ResponseEntity<BasicData> save(@RequestBody BasicData basicData){
		basicDataService.save(basicData);
		return new ResponseEntity<BasicData>(HttpStatus.OK);
	}
	
	/***** METODOS PRIVADOS *****/
	
	private BasicDataDTO convertToDTO(BasicData basicData){
		BasicDataDTO dto = new BasicDataDTO();
		dto.setId(basicData.getId());
		dto.setFirstName(basicData.getFirstName());
		dto.setLastName(basicData.getLastName());
		
		return dto;
	}

}
