/**
 * Controlador responsável por gerenciar a listagem de todos os endereços de uma pessoa.
 */

package br.com.desafio.api.controller.address_control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.service.person_impl.FindAllAddressPersonService;

@RestController
public class ListAllAddresses {
	
	@Autowired
    private FindAllAddressPersonService impl;
	
	
	/**
	 * Método que retorna uma lista com todos os endereços de uma pessoa específica.
	 * @param id o ID da pessoa para quem os endereços serão retornados
	 * @return  entidade de pessoa com sua lista de endereço
	 */
	 @GetMapping("/person/{id}/full")
	    public PersonEntity findallAddress(@PathVariable Long id) {
	        return impl.findAllAddress(id);
	    }

}
