/**
 * Controlador responsável por gerenciar a operação de atualização de dados de uma pessoa.
 */

package br.com.desafio.api.controller.person_control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.service.person_impl.UpdatePersonService;

@RestController
public class UpdatePerson {
	
	@Autowired
	private UpdatePersonService impl;
	
	/**
	 * Método que atualiza os dados de uma pessoa específica.
	 * @param id o ID da pessoa a ser atualizada
	 * @param person as novas informações da pessoa, enviadas na requisição
	 * @return a pessoa atualizada
	 * @throws Exception caso ocorra algum erro
	 */
	@PutMapping("/person/{id}")
    public PersonEntity personUpdate(@PathVariable Long id, @RequestBody PersonEntity person) throws Exception {
        return impl.updateData(id, person);
    }

}
