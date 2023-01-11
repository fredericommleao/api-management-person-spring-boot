/**
* A classe AddressEntity representa um endereço. 
* Possui diversos campos, como id, logradouro, cep, número, cidade, principal, pessoa.
* Está também anotada como uma entidade e tem uma relação com a classe PersonEntity com a anotação @ManyToOne 
*
* @author Fred
* 
*/

package br.com.desafio.api.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "endereco")
public class AddressEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
    private PersonEntity pessoa;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	private boolean principal;
	
	
	/**
	* AddressEntity é o construtor que recebe o logradouro como parametro
	* @param logradouro
	*/
	public AddressEntity(String logradouro){
		this.logradouro = logradouro ;
	}
	
	
	public AddressEntity() {}
	
	/**
	* setPessoa configura a pessoa do endereço
	* @param pessoa
	*/
	public void setPessoa(PersonEntity pessoa) {
	    this.pessoa = pessoa;
	}
	
	/**
	* isPrincipal retorna se é o endereço principal
	* @return principal
	*/
	public boolean isPrincipal() {
		return principal;
	}
	
	/**
	* setPrincipal configura se é o endereço principal
	* @param principal
	*/
	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}
	
	
	/**
	* id é usado para identificar o endereço no sistema.
	* @return id
	*/
	public Long getId() {
		return id;
	}
	
	/**
	* setId configura o id do endereço
	* @param id
	*/
	public void setId(Long id) {
		this.id = id;
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
