/*
 * classe customizado de exception que é 
 * utilizada em vários métodos de outras classes
 * */

package br.com.desafio.api.exception;

public class CustomException extends RuntimeException{
	
	public CustomException() {	
		
		super("Pessoa não encontrada");			
	}

}