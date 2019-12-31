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

import com.treino.consoles.domain.Fabricante;
import com.treino.consoles.services.FabricanteService;

@RestController
@RequestMapping(value="/fabricantes")
public class FabricanteController {
	
	@Autowired
	FabricanteService service;
	
	//Get-All-Fabricantes
	@RequestMapping(method=RequestMethod.GET)
	public List<Fabricante> listAll(){
		return service.listAll();
	}
	
	//Get-By-ID
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Fabricante> foundById(@PathVariable Integer id){
		Fabricante obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//Adicionando-Fabricante
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Fabricante> insert(@RequestBody Fabricante obj){
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Delete
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//Put
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Fabricante obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
}
