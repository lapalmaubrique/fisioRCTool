package com.example.restController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ActorDTO;
import com.example.model.Actor;
import com.example.service.ActorService;

@RestController
@RequestMapping(value = "/actores/")
public class ActorController {
	
	@Autowired
	private ActorService actorService;
	
	@GetMapping(value = "findAll")
	public List<ActorDTO> findAll(){
		List<ActorDTO> listDTO = new ArrayList<ActorDTO>();
		List<Actor> list = actorService.findAll();
		for (Actor actor : list) {
			listDTO.add(convertToDTO(actor));
		}
		return listDTO;
	}
	
	@GetMapping(value = "findById/{id}")
	public ActorDTO findById(@PathVariable Integer id){
		return convertToDTO(actorService.findById(id));
	}
	
	@PostMapping(value = "save")
	public ResponseEntity<Actor> save(@RequestBody Actor actor){
		actorService.save(actor);
		return new ResponseEntity<Actor>(HttpStatus.OK);
	}
	
	@PutMapping(value = "update")
	public ResponseEntity<Actor> update(@RequestBody Actor actor){
		actorService.update(actor);
		return new ResponseEntity<Actor>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity<Actor> delete(@PathVariable Integer id){
		actorService.delete(id);
		return new ResponseEntity<Actor>(HttpStatus.OK);
	}
	
	/***** METODOS PRIVADOS *****/
	
	private ActorDTO convertToDTO(Actor actor){
		ActorDTO dto = new ActorDTO();
		dto.setId(actor.getId());
		dto.setFirstName(actor.getFirstName());
		dto.setLastName(actor.getLastName());
		
		//Convertimos el date a string
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dto.setLastUpdateString(df.format(actor.getLastUpdate()));
		
		return dto;
	}

}
