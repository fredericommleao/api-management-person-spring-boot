/*
 * FindMainAddressService é uma classe de serviço responsável por encontrar o endereço principal de uma pessoa.
 * */
package br.com.desafio.api.service.address_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.api.domain.entity.AddressEntity;
import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.exception.CustomException;
import br.com.desafio.api.repository.PersonRepository;

@Service
public class FindMainAddressService {
		 
	@Autowired
	private PersonRepository pessoaRepository;
	
	/**
	* O método findMainAddress encontra o endereço principal de uma pessoa.
	*
	* @param pessoa entidade pessoa para a qual o endereço principal será encontrado
	* @param id id da pessoa para a qual o endereço principal será encontrado
	* @throws CustomException se pessoa não for encontrada
	* @return o endereço principal da pessoa, se encontrado; caso contrário, null
	*/
	public AddressEntity findMainAddress(PersonEntity pessoa, Long id) throws CustomException {
   	 pessoa = pessoaRepository.findById(id).orElseThrow(CustomException :: new);
       if (pessoa == null) {
           throw new RuntimeException();
       }
       for (AddressEntity address : pessoa.listAddress) {
           if (address.isPrincipal()) {
               return address;
           }
       }
       return null ;
   }

}
