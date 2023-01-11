/*
 *  AddMainAddressService é uma classe de serviço responsável por definir o endereço principal de uma pessoa.
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
public class AddMainAddressService {
	
	@Autowired
	private AddressRepository addressRepository ;
	
	@Autowired
	private PersonRepository personRepository ;
	
	/**
	    * O método mainAddress define o endereço principal de uma pessoa
	    *
	    * @param contactId id da pessoa
	    * @param addressId id do endereço
	    * @throws CustomException se personEntity ou addressEntity não for encontrado
	    */
	
	public void mainAddress(Long contactId, Long addressId) throws CustomException{
        PersonEntity personEntity = personRepository.findById(contactId).orElse(null);
        AddressEntity addressEntity = addressRepository.findById(addressId).orElse(null);
        if(personEntity == null || addressEntity == null) {
            throw new CustomException();
        }
        personEntity.setMainAddress(addressEntity);
        personRepository.save(personEntity);
    }
}
