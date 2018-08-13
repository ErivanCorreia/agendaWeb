package com.agenda.webapp.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ContatoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Set<String> telefones = new HashSet<>();
	private Set<String> emails = new HashSet<>();
	
	private Integer enderecoId;
	
	public ContatoDTO() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}

	public Integer getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}
	
	

}
