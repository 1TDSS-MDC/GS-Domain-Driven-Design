package br.com.fiap.baze.exception;

public class IdNotFoundException extends Exception {
	
	public IdNotFoundException() {}
	
	public IdNotFoundException(String mensagem) {
		super(mensagem);
	}
}
