package com.agenda.webapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.agenda.webapp.domain.Endereco;
import com.agenda.webapp.exceptions.ObjectNotFoundException;
import com.agenda.webapp.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> findAll(){
		return enderecoRepository.findAll();
	}
	
	public Endereco find(Integer id) {
		Optional<Endereco> obj = enderecoRepository.findById(id);
		
		try {
			return obj.orElseThrow(() -> new  ObjectNotFoundException("Endereço Inexistente ! Id:" +id+ ""));
		} catch (ObjectNotFoundException e) {
			// TODO Auto-generated catch block
		 
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ObjectNotFoundException("Endereço Inexistente ! Id:" +id+ ""));
		}

		return null;
	}
	
	
	public Endereco insert(Endereco obj) {
		obj.setId(null);
		
		return enderecoRepository.save(obj);
	}

}
