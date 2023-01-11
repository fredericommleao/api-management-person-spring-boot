/*
 * UpdatePersonService é uma classe de serviço responsável por atualizar informações de uma pessoa existente no banco de dados.
 * */
package br.com.desafio.api.service.person_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.api.domain.entity.PersonEntity;
import br.com.desafio.api.exception.CustomException;
import br.com.desafio.api.repository.PersonRepository;

@Service
public class UpdatePersonService {
	
	@Autowired
	private PersonRepository pessoaRepository;
	
	
	/**
	* O método updateData atualiza as informações de uma pessoa existente no banco de dados
	*
	* @param id o id da pessoa a ser atualizada
	* @param pessoa entidade pessoa contendo as novas informações
	* @throws CustomException se a pessoa não for encontrada
	* @return a pessoa atualizada
	*/
	public PersonEntity updateData(Long id, PersonEntity pessoa) throws CustomException {
		
        PersonEntity personIsNotEmpty = pessoaRepository.findById(id).orElseThrow(CustomException :: new);
        
        if (personIsNotEmpty == null) {
        	
            throw new CustomException();
        }

        personIsNotEmpty.setNome(pessoa.getNome());
        
        personIsNotEmpty.setDataNascimento(pessoa.getDataNascimento());

        return pessoaRepository.save(personIsNotEmpty);
    }

}
