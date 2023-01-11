/**
* A classe PersonEntity representa uma pessoa. 
* Possui diversos campos, como id, listAddress, nome, dataNascimento.
* Está anotada como uma entidade e tem uma relação com a classe AddressEntity com a anotação @OneToMany 
*
* @author Fred
*/


package br.com.desafio.api.domain.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "pessoa")
public class PersonEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	public List<AddressEntity> listAddress;
	private String nome;
	private LocalDate dataNascimento;
	
	/**
	* Construtor vazio 
	*/
	public PersonEntity() {}
	
	/**
	* Construtor que recebe nome e data de nascimento
	* @param name
	* @param date
	*/
	public PersonEntity(String name , LocalDate date) {}
	
	/**
	* getId retorna o id da pessoa
	* @return id
	*/
	public Long getId() {
	    return id;
	}

	/**
	* setId configura o id da pessoa
	* @param id
	*/
	public void setId(Long id) {
	    this.id = id;
	}

	/**
	* setAddress configura a lista de endereços da pessoa
	* @param address
	*/
	public void setAddress(List<AddressEntity> address) {
	    this.listAddress = address;
	    }
	
	/**
	* setMainAddress configura o endereço principal da pessoa
	* @param address
	*/
	public void setMainAddress(AddressEntity address) {
	     for (AddressEntity e : listAddress) {
	       e.setPrincipal(false);
	    }
	       address.setPrincipal(true);
	}
	
	/**
	* getNome retorna o nome da pessoa
	* @return nome
	*/
	public String getNome() {
		return nome;
	}
	/**
	* setNome configura o nome da pessoa
	* @param nome
	*/
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	* getDataNascimento retorna a data de nascimento da pessoa
	* @return dataNascimento
	*/
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	/**
	* setDataNascimento configura a data de nascimento da pessoa
	* @param dataNascimento
	*/
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	/**
	* setDataNascimento configura a data de nascimento da pessoa a partir de uma string no formato "dd/MM/yyyy"
	* @param birthDate
	*/
	public void setDataNascimento(String birthDate) {
	    this.dataNascimento = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}


