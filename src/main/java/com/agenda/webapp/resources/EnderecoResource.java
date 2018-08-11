package com.agenda.webapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.webapp.domain.Endereco;
import com.agenda.webapp.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	private ResponseEntity<List<Endereco>> findAll(){
		
		List<Endereco> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
}
