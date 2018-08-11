package com.agenda.webapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.webapp.domain.Contato;
import com.agenda.webapp.services.ContatoService;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoResource {

	@Autowired
	private ContatoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET )
	public ResponseEntity<Contato> find(@PathVariable Integer id){
		Contato obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Contato>> findAll(){
		List<Contato> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Contato> insert(@RequestBody Contato obj){
		service.insert(obj);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Contato> update(@RequestBody Contato obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		Contato obj = service.find(id);
		service.delete(obj);
		
		return ResponseEntity.noContent().build();
	}
	
}
