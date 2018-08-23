package com.agenda.webapp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.agenda.webapp.domain.Contato;
import com.agenda.webapp.domain.Endereco;
import com.agenda.webapp.repositories.ContatoRepository;
import com.agenda.webapp.repositories.EnderecoRepository;

@SpringBootApplication
public class AgendawebappApplication implements CommandLineRunner{
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AgendawebappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Endereco e1 = new Endereco("João Pessoa", "PB", "Bairro A", "Rua B");
		
		Contato c1= new Contato(null, "Erivan Correia", e1);
		c1.getTelefones().addAll(Arrays.asList("88559881", "87976585"));
		c1.getEmails().addAll(Arrays.asList("erivann47@gmail.com", "erivanj@outlook.com"));
		
		Contato c2= new Contato(null, "Daniel Fernando", e1);
		c2.getTelefones().addAll(Arrays.asList("559996611"));
		c2.getEmails().addAll(Arrays.asList("daniel@gmail.com", "danielj@outlook.com"));
		
		Contato c3= new Contato(null, "Jussara Granja", e1);
		c3.getTelefones().addAll(Arrays.asList("88224477", "99771133"));
		c3.getEmails().addAll(Arrays.asList("jussara@gmail.com"));
	
		
		e1.getContato().addAll(Arrays.asList(c1, c2, c3));
		
		contatoRepository.saveAll(Arrays.asList(c1, c2, c3));
		enderecoRepository.saveAll(Arrays.asList(e1));
		
	}
	
}
