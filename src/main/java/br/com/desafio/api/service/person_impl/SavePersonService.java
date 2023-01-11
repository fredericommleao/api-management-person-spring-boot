/*
 * SavePersonService é uma classe de serviço responsável por salvar uma pessoa no banco de dados.
 * */
package br.com.desafio.api.service.person_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.repository.PersonRepository;

@Service
public class SavePersonService {
	
	@Autowired
    private PersonRepository personRepository;
	
	/**
	* O método save salva uma pessoa no banco de dados.
	* @param person entidade pessoa a ser salva
	*/
    public void save(PersonEntity person) {
    	personRepository.save(person);
    }
}
