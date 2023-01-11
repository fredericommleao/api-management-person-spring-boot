/*
 * FindAllPersonService é uma classe de serviço responsável por encontrar todas as pessoas.
 * */
package br.com.desafio.api.service.person_impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.api.domain.entity.AddressEntity;
import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.repository.PersonRepository;

@Service
public class FindAllPersonService {
	
	public FindAllPersonService() {
		
	}
	
	public FindAllPersonService(PersonRepository personRepository) {
		this.pessoaRepository = personRepository ;
	}
	
	@Autowired
    private PersonRepository pessoaRepository;
	
	/**
	* O método findAll encontra todas as pessoas
	* @return lista de todas as pessoas encontradas
	*/
    public List<PersonEntity> findAll() {
        List<PersonEntity> person = (List<PersonEntity>) pessoaRepository.findAll();
        for (PersonEntity pessoa : person) {
            if (pessoa.listAddress.isEmpty()) {
                pessoa.listAddress = Collections.singletonList(new AddressEntity("O endereco ainda não foi cadastrado"));
            }
        }
        return person;
    }

}
