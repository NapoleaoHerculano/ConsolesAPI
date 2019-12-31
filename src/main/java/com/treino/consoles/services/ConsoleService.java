package com.treino.consoles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treino.consoles.domain.Console;
import com.treino.consoles.repositories.ConsoleRepository;

@Service
public class ConsoleService {
	
	@Autowired 
	ConsoleRepository repository;
	
	//GET-All
	public List<Console> listAll(){
		return repository.findAll();
	}
	
	//Get-By-ID
	public Console find(Integer id) {
		Optional<Console> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	//POST
	public Console insert(Console obj) {
		return repository.save(obj);
	}
	
	//PUT
	public Console update(Console oldC) {
		Console newC = find(oldC.getId());
		auxiliarUpdate(newC, oldC);
		return repository.save(newC);
	}
	
	//DELETE
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	private void auxiliarUpdate(Console newC, Console oldC) {
		newC.setNome(oldC.getNome());
		newC.setDataLancamento(oldC.getDataLancamento());
		newC.setStatusAtividade(oldC.getStatusAtividade());
		newC.setFabricante(oldC.getFabricante());
		newC.setDescricao(oldC.getDescricao());
	}
}
