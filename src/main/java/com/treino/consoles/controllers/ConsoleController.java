package com.treino.consoles.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.treino.consoles.domain.Console;
import com.treino.consoles.services.ConsoleService;


@RestController
@RequestMapping("/v1/api/consoles")
public class ConsoleController {
	
	@Autowired
	ConsoleService service;
	
	//GET-ALL
	@RequestMapping(method=RequestMethod.GET)
	public List<Console> listAll(){
		return service.listAll();
	}
	
	//POST
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Console> insert(@RequestBody Console obj){
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//PUT
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> put(@RequestBody Console obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	//DELETE
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	//FOUND-BY-ID
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Console> foundById(@PathVariable Integer id){
		Console obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
