package com.treino.consoles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.treino.consoles.domain.Fabricante;
import com.treino.consoles.repositories.FabricanteRepository;

@Service
public class FabricanteService {
	
	@Autowired
	FabricanteRepository repository;
	
	//GET-ALL
	public List<Fabricante> listAll(){
		return repository.findAll();
	}
	
	//POST
	public Fabricante insert(Fabricante obj) {
		return(repository.save(obj));
	}
	
	//DELETE
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			System.out.println("Não foi possível deletar");
			
		}
	}
	
	//PUT
	public Fabricante update(Fabricante oldFab) {
		Fabricante newFab = find(oldFab.getId());
		auxiliarUpdate(newFab, oldFab);
		return repository.save(newFab);
	}
	
	//GET-BY-ID
	public Fabricante find(Integer id) {
		Optional<Fabricante> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	private void auxiliarUpdate(Fabricante newFab, Fabricante oldFab) {
		newFab.setNome(oldFab.getNome());
		newFab.setAnoFundacao(oldFab.getAnoFundacao());
		newFab.setPais(oldFab.getPais());
		newFab.setConsoles(oldFab.getConsoles());
	}
	
}
