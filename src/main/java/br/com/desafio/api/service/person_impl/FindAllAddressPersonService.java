/*
 * FindAllAddressPersonService é uma classe de serviço responsável por encontrar todos os endereços de uma pessoa.
 * */
package br.com.desafio.api.service.person_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.exception.CustomException;
import br.com.desafio.api.repository.PersonRepository;

@Service
public class FindAllAddressPersonService {
	
	 	@Autowired
	    private PersonRepository personRepository;
	 	
	 	
	 	/**
	    * O método findAllAddress encontra todos os endereços de uma pessoa específica.
	    *
	    * @param id id da pessoa para a qual os endereços serão encontrados
	    * @throws CustomException se pessoa não for encontrada
	    * @return objeto Pessoa com todos os endereços encontrados
	    */
	    public PersonEntity findAllAddress(Long id) throws CustomException{
	        PersonEntity pessoa = personRepository.findById(id).orElseThrow(CustomException :: new);
	        if (pessoa == null) {
	            throw new CustomException();
	        }
	        pessoa.listAddress.size();
	        return pessoa;
	    }

}
