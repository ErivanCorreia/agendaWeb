package com.agenda.webapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.agenda.webapp.domain.Contato;
import com.agenda.webapp.dto.ContatoDTO;
import com.agenda.webapp.services.ContatoService;


//@RequestMapping(value = "/contatos")
@Controller
public class ContatoResource {

	@Autowired
	private ContatoService service;
	
	@RequestMapping(value = "/cadastrarContato", method = RequestMethod.GET)
	public String insert() {
		return "contato/formContato";
	}
	
	@RequestMapping(value = "/cadastrarContato", method = RequestMethod.POST)
	public String insert(ContatoDTO objDTO) {
		
		Contato obj = service.toContatoDTO(objDTO);
		
		service.insert(obj);
		
		return "redirect:/cadastrarContato";
	}
	
	@RequestMapping("/contatos")
	public ModelAndView listar(){
		
		ModelAndView mv = new ModelAndView("index");
		List<Contato> list = service.findAll();
		mv.addObject("contatos", list);
		
		return mv;
	}
	/*
		@RequestMapping(value="/contatos", method = RequestMethod.GET)
		public ResponseEntity<List<Contato>> findAll(){
			List<Contato> list = service.findAll();
			
			return ResponseEntity.ok().body(list);
		}*/
	
	
/*	
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
	public ResponseEntity<Contato> insert(@RequestBody ContatoDTO objDTO){
		Contato obj = service.toContatoDTO(objDTO);
		service.insert(obj);
		return ResponseEntity.ok().build();
	}
	
	
	
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Contato> update(@RequestBody ContatoDTO objDTO, @PathVariable Integer id){
			
			Contato obj = service.toContatoDTO(objDTO);
			
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
*/
	
}
