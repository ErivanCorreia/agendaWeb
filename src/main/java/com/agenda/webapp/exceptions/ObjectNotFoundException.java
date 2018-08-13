package com.agenda.webapp.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public ObjectNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	

}
