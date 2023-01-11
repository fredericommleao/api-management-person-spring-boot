/**
 * Controlador responsável por gerenciar a operação de busca do endereço principal de uma pessoa.
 */

package br.com.desafio.api.controller.address_control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.api.domain.entity.AddressEntity;
import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.service.address_impl.FindMainAddressService;

@RestController
public class ListMainAddress {
	
	@Autowired
	private FindMainAddressService Impl;
	 
	/**
	 * Método que retorna o endereço principal de uma pessoa específica.
	 * @param id o ID da pessoa para quem o endereço principal será retornado
	 * @param person Entidade pessoa passada para o metodo (completando o registro)
	 * @return o endereço principal da pessoa
	 */
	
	@GetMapping("/person/{id}/addresses/primary")
    public AddressEntity callAddressPrimay(@PathVariable Long id,PersonEntity person) 
	{
       
        return Impl.findMainAddress(person , id);
    }

}
