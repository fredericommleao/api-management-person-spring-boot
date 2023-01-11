/*
 * ListByIdPersonService é uma classe de serviço responsável por encontrar uma pessoa específica a partir de seu ID.
 * */
package br.com.desafio.api.service.person_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.exception.CustomException;
import br.com.desafio.api.repository.PersonRepository;

@Service
public class ListByIdPersonService {
	
	 @Autowired
	 private PersonRepository personRepository;
	 
	 /**
	 * O método listbyId encontra uma pessoa específica a partir de seu ID.
	 *
	 * @param id o id da pessoa a ser encontrada
	 * @throws CustomException se a pessoa não for encontrada
	 * @return a pessoa encontrada
	 */
	 public PersonEntity listbyId(Long id) throws CustomException{
	    	
	    return personRepository.findById(id).orElseThrow(CustomException :: new);
	 }

}
