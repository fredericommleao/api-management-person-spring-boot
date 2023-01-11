/**
* A classe Person é o modelo para a classe PersonEntity. 
* todos os seus atributos e metodos são os mesmos porém sem as anotações
*
* @author Fred
*/
package br.com.desafio.api.domain.model;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;

import br.com.desafio.api.domain.entity.AddressEntity;


public class Person {
	

	private Long id;
	private String name;
	private LocalDate birthDate;
	
	
	public List<AddressEntity> address;
	
	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	   

	public void setAddress(List<AddressEntity> address) {
	    this.address = address;
	    }
	 
	public void markMainAddress(AddressEntity addressEntity) {
	    for (AddressEntity e : address) {
	       e.setPrincipal(false);
	    }
	       addressEntity.setPrincipal(true);
	}
	   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	 public void setBirthDate(String birthDate) {
	        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	    }
	 
	 public void setBirthDate(LocalDate birthDate) {
		    this.birthDate = birthDate;
		}

}


