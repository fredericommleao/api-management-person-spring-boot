/**
 * Controlador responsável por gerenciar a criação de uma pessoa.
 */

package br.com.desafio.api.controller.person_control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.service.person_impl.SavePersonService;

@RestController
public class CreatePerson {
	
	@Autowired
    private SavePersonService impl;
	
	/**
	 * Método que salva uma pessoa
	 * @param person Entidade pessoa a ser salva.
	 */
	@PostMapping("/person")
    public void save(@RequestBody PersonEntity person) {
		impl.save(person);
    }

}
