package com.agenda.webapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.webapp.domain.Contato;
import com.agenda.webapp.repositories.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	
	public Optional<Contato> find(Integer id) {
		Optional<Contato> obj  = contatoRepository.findById(id);
		
		return obj;
	}
	
	public List<Contato> findAll() {
		return contatoRepository.findAll();
	}
	
	public Contato insert(Contato obj) {
		obj.setId(null);
		return contatoRepository.save(obj);
	}
	
	public Contato update(Contato obj) {
		find(obj.getId());
		return contatoRepository.save(obj);
	}

	
}
