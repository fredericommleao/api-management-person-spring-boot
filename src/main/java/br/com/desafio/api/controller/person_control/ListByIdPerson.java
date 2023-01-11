/**
 * Controlador responsável por gerenciar a operação de buscar uma pessoa específica pelo ID.
 */

package br.com.desafio.api.controller.person_control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.service.person_impl.FindAllAddressPersonService;
import br.com.desafio.api.service.person_impl.ListByIdPersonService;

@RestController
public class ListByIdPerson {
	
	@Autowired
    private ListByIdPersonService impl;
	
	/**
	 * Método que retorna uma pessoa específica pelo seu ID.
	 * @param id o ID da pessoa a ser retornada
	 * @return a pessoa encontrada
	 */
	@GetMapping("/person/{id}")
    public PersonEntity listById(@PathVariable Long id) {
		
		return impl.listbyId(id);       
    }

}
