/*
 * CreateAddressService é uma classe de serviço responsável por criar um endereço para uma pessoa.
 * */
package br.com.desafio.api.service.address_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.api.domain.entity.AddressEntity;
import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.exception.CustomException;
import br.com.desafio.api.repository.AddressRepository;
import br.com.desafio.api.repository.PersonRepository;

@Service
public class CreateAddressService {
	
	
	@Autowired
    private AddressRepository enderecoRepository;
 
	@Autowired
    private PersonRepository pessoaRepository;
	
	/**
	    * O método createAddress cria um novo endereço para uma pessoa específica.
	    *
	    * @param person entidade pessoa a qual o endereço será vinculado
	    * @param address entidade endereço que será criado
	    * @param id id da pessoa a qual o endereço será vinculado
	    * @throws CustomException se pessoa não for encontrada
	    * @return o endereço criado e salvo
	    */
    public AddressEntity createAddress(PersonEntity person, AddressEntity address, Long id) throws CustomException {
        
        
    	person = pessoaRepository.findById(id).orElseThrow(CustomException :: new);
        if (person == null) {
            throw new CustomException();
        }
           	
    	if (address.isPrincipal()) {
            
            for (AddressEntity e : person.listAddress) {
                e.setPrincipal(false);
            }
        }
        address.setPessoa(person);
        return enderecoRepository.save(address);
    }

}
