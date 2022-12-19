package br.com.comex.modelo;

public class ComexException extends RuntimeException {
	String mensagem;
	
	public ComexException() {
		super();
	}
	public ComexException(String mensagem) {
		super(mensagem);
		
	}
	
	
}
