/**
 * Controlador responsável por gerenciar a operação de listagem de todas as pessoas.
 */

package br.com.desafio.api.controller.person_control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.service.person_impl.FindAllPersonService;

@RestController
public class ListAllPerson {
	
	@Autowired
    private FindAllPersonService impl;
		
	/**
	 * Método que retorna uma lista com todas as pessoas cadastradas.
	 * @return lista de pessoas
	 */
	 @GetMapping("/person")
     public List<PersonEntity> listAllPerson() {
         return impl.findAll();
     }

}
