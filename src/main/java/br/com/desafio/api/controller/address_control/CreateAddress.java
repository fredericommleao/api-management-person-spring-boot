/**
 * Controlador responsável pela criação de um endereço para uma pessoa.
 */

package br.com.desafio.api.controller.address_control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.api.domain.entity.AddressEntity;
import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.service.address_impl.CreateAddressService;

@RestController
public class CreateAddress {
	
	@Autowired
    private CreateAddressService impl;
	
	
	/**
	 * Método que cria um endereço para uma pessoa específica.
	 * @param id o ID da pessoa para quem o endereço será criado
	 * @param address os dados do endereço a ser criado,
	 * @param person entidade pessoa passada para o metodo (completando o registro)
	 * @return o endereço criado
	 */
	
	@PostMapping("/person/{id}/addresses")
    public AddressEntity createAddress(@PathVariable Long id, 
    		@RequestBody AddressEntity address, PersonEntity person) {
        
        return impl.createAddress(person, address, id);
    }

}
