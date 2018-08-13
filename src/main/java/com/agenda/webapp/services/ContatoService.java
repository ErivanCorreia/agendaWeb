package com.agenda.webapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.agenda.webapp.domain.Contato;
import com.agenda.webapp.dto.ContatoDTO;
import com.agenda.webapp.exceptions.ObjectNotFoundException;
import com.agenda.webapp.repositories.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	
	public Contato find(Integer id) {
		Optional<Contato> obj  = contatoRepository.findById(id);
		
			try {
				return obj.orElseThrow(() -> new  ObjectNotFoundException("Contato Inexistente ! Id:" +id+ ""));
			} catch (ObjectNotFoundException e) {
				// TODO Auto-generated catch block
			 
				ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ObjectNotFoundException("Contato Inexistente ! Id:" +id+ ""));
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
		newobj.setEndereco(obj.getEndereco());

		return contatoRepository.save(newobj);
	
	}
	
	public Contato toContatoDTO(ContatoDTO objDTO) {
		
		Contato obj = new Contato(null, objDTO.getNome(), null);
		obj.getEmails().addAll(objDTO.getEmails());
		obj.getTelefones().addAll(objDTO.getTelefones());
		obj.setEndereco(enderecoService.find(objDTO.getEnderecoId()));
		
		return obj;
	
	}
	
	
	public void delete(Contato contato) {
		Contato newContato = find(contato.getId());
		newContato.setEndereco(null);
		
			contatoRepository.delete(newContato);		
	}

	
}
