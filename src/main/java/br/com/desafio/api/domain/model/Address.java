/**
* A classe Address é o modelo para a classe AddressEntity. 
* todos os seus atributos e metodos são os mesmos porém sem as anotações
*
* @author Fred
*/
package br.com.desafio.api.domain.model;

public class Address {
	
	
	private Long id;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	private boolean principal;
	
	
	
	public Address(String logradouro){
		this.logradouro = logradouro ;
	}
	public Address() {}
	
	
	
	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public boolean isPrimary() {
		return principal;
	}
	public void setPrimary(boolean principal) {
		this.principal = principal;
	}
	   
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	   
}
