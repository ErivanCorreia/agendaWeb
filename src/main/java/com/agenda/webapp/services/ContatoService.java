package com.agenda.webapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.agenda.webapp.domain.Contato;
import com.agenda.webapp.exceptions.ContatoNotFoundException;
import com.agenda.webapp.repositories.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	
	public Contato find(Integer id) {
		Optional<Contato> obj  = contatoRepository.findById(id);
		if(id != null) {
			try {
				return obj.orElseThrow(() -> new  ContatoNotFoundException("Contato Inexistente ! Id:" +id+ ""));
			} catch (ContatoNotFoundException e) {
				// TODO Auto-generated catch block
			 
				ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ContatoNotFoundException("Contato Inexistente ! Id:" +id+ ""));
			}
		}
		return null;
	}
	
	public List<Contato> findAll() {
		return contatoRepository.findAll();
	}
	
	public Contato insert(Contato obj) {
		obj.setId(null);
		return contatoRepository.save(obj);
	}
	
	public Contato update(Contato obj) {
	
		Contato newobj = find(obj.getId());
		newobj.setNome(obj.getNome());
		newobj.setTelefones(obj.getTelefones());
		newobj.setEmails(obj.getEmails());

		return contatoRepository.save(newobj);
	
	}
	
	public void delete(Contato contato) {
		Contato newContato = find(contato.getId());
		newContato.setEndereco(null);
		
			contatoRepository.delete(newContato);		
	}

	
}
